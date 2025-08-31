import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BookingService } from '../../core/services/booking.service';
import { Flight } from '../../core/models/flight.model';
import { Passenger } from '../../core/models/passenger.model';
import { DurationPipe } from '../../pipes/duration.pipe';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [CommonModule, DurationPipe],
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  flight: Flight | null = null;
  passenger: Passenger | null = null;
  loading = false;

  constructor(private router: Router, private toast: ToastrService, private bookingService: BookingService) {}

  ngOnInit(): void {
    const flightStored = localStorage.getItem('selectedFlight');
    const passengerStored = localStorage.getItem('passenger');
    if (flightStored) {
      this.flight = JSON.parse(flightStored);
    }
    if (passengerStored) {
      this.passenger = JSON.parse(passengerStored);
    }
    if (!this.flight || !this.passenger) {
      this.toast.error('Missing flight or passenger details. Please start over.');
      this.router.navigate(['/flight-results']);
    }
  }

  proceedToPay() {
    if (this.loading || !this.flight || !this.passenger) return;
    this.loading = true;
    this.bookingService.createBooking(this.flight.id, this.passenger).subscribe({
      next: (booking) => {
        this.toast.success('Booking created successfully');
        this.router.navigate(['/payment', booking.id]);
      },
      error: (err) => {
        this.toast.error('Error creating booking: ' + err.message);
        this.loading = false;
      }
    });
  }
}