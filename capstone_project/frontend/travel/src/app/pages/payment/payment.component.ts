import { CommonModule } from '@angular/common';
import { Component, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BookingService } from '../../core/services/booking.service';
import { PaymentService } from '../../core/services/payment.service';
import { CardPayment } from '../../core/models/payment.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnDestroy {
  bookingId = 0;
  loading = false;
  sub?: Subscription;

  payment: CardPayment = {
    amount: 0,
    method: 'CREDIT_CARD',
    cardNumber: '',
    nameOnCard: '',
    expiryMonth: '',
    expiryYear: '',
    cvv: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService,
    private bookingService: BookingService,
    private paymentService: PaymentService
  ) {
    this.route.queryParamMap.subscribe(p => {
      const id = p.get('bookingId') || localStorage.getItem('bookingId');
      this.bookingId = id ? +id : 0;
    });

    const selected = localStorage.getItem('selectedFlight');
    const price = selected ? JSON.parse(selected).price : 5500;
    this.payment.amount = Math.round(price || 5500);
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe();
  }

  valid(): boolean {
    const n = this.payment.cardNumber.replace(/\s+/g, '');
    const validCard = /^\d{16}$/.test(n);
    const validCvv = /^\d{3}$/.test(this.payment.cvv);
    const m = +this.payment.expiryMonth;
    const y = +this.payment.expiryYear;
    const now = new Date();
    const future = y > now.getFullYear() || (y === now.getFullYear() && m >= (now.getMonth() + 1));
    return validCard && validCvv && m >= 1 && m <= 12 && future;
  }

  pay() {
    if (!this.bookingId) { this.toastr.error('Booking Id missing'); return; }
    if (!this.valid()) { this.toastr.error('Invalid card details'); return; }

    this.loading = true;
    this.paymentService.initiatePayment(this.bookingId, this.payment).subscribe({
      next: () => {
        this.toastr.info('Payment initiated...');
        this.sub = this.bookingService.pollStatus(this.bookingId, 1000, 30000).subscribe({
          next: (res) => {
            if (res?.status === 'successful') {
              this.toastr.success('Payment successful');
              this.router.navigate(['/confirmation'], { queryParams: { bookingId: this.bookingId } });
            } else if (res?.status === 'failed') {
              this.toastr.error('Payment failed');
              this.router.navigate(['/failed'], { queryParams: { bookingId: this.bookingId } });
            }
          },
          complete: () => { this.loading = false; },
          error: () => { this.loading = false; this.toastr.error('Error checking status'); }
        });
      },
      error: () => { this.loading = false; this.toastr.error('Failed to initiate payment'); }
    });
  }
}

