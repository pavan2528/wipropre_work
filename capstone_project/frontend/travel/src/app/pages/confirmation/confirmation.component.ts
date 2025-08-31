import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookingService } from '../../core/services/booking.service';
import { Booking } from '../../core/models/booking.model';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';

@Component({
selector: 'app-confirmation',
standalone: true,
imports: [CommonModule],
templateUrl: './confirmation.component.html',
styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent {
@ViewChild('ticket', { static: false }) ticketRef!: ElementRef<HTMLDivElement>;
booking: Booking | null = null;
bookingId!: number;

constructor(private route: ActivatedRoute, private bookingService: BookingService) {
this.route.queryParamMap.subscribe(p => {
const id = p.get('bookingId');
this.bookingId = id ? +id : 0;
if (this.bookingId) {
this.bookingService.getBookingById(this.bookingId).subscribe(b => this.booking = b);
}
});
}

async downloadPdf() {
if (!this.ticketRef) return;
const el = this.ticketRef.nativeElement;
const canvas = await html2canvas(el);
const imgData = canvas.toDataURL('image/png');
const pdf = new jsPDF('p', 'mm', 'a4');
const imgProps = (pdf as any).getImageProperties(imgData);
const pdfWidth = 190;
const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;
pdf.addImage(imgData, 'PNG', 10, 10, pdfWidth, pdfHeight);
pdf.save(`ticket_${this.bookingId}.pdf`);
}
}