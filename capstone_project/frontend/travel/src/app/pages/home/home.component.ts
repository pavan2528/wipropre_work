import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  origin: string = '';
  destination: string = '';
  date: Date = new Date();
  minDate: Date = new Date(); 

  airports = [
    { code: 'CCU', city: 'Kolkata', airport: 'Netaji Subhas Chandra Bose Intl' },
    { code: 'MAA', city: 'Chennai', airport: 'Chennai International Airport' },
    { code: 'BLR', city: 'Bangalore', airport: 'Kempegowda International Airport' },
    { code: 'DEL', city: 'New Delhi', airport: 'Indira Gandhi International Airport' },
    { code: 'BOM', city: 'Mumbai', airport: 'Chhatrapati Shivaji Maharaj Intl' }
  ];
  filteredFrom: any[] = [];
  filteredTo: any[] = [];

  constructor(private router: Router) {}

  filterFrom(value: string) {
    const lowerValue = value.toLowerCase();
    this.filteredFrom = this.airports.filter(a => a.city.toLowerCase().includes(lowerValue) || a.code.toLowerCase().includes(lowerValue));
  }

  filterTo(value: string) {
    const lowerValue = value.toLowerCase();
    this.filteredTo = this.airports.filter(a => a.city.toLowerCase().includes(lowerValue) || a.code.toLowerCase().includes(lowerValue));
  }

  selectFrom(a: any) {
    this.origin = `${a.city} (${a.code})`;  // Show full "City (Code)" in input
    this.filteredFrom = [];
  }

  selectTo(a: any) {
    this.destination = `${a.city} (${a.code})`;  // Show full "City (Code)" in input
    this.filteredTo = [];
  }

  swapLocations() {
    const temp = this.origin;
    this.origin = this.destination;
    this.destination = temp;
  }

  searchFlights() {
    if (this.origin.length < 3 || this.destination.length < 3) {
      alert('Please enter at least 3 characters for From and To.');
      return;
    }
    // Extract city from "City (Code)" for backend (backend expects city)
    const originCity = this.origin.split(' (')[0];
    const destinationCity = this.destination.split(' (')[0];
  // Format date in local timezone to avoid shifting to previous day (no UTC conversion)
  const formattedDate = `${this.date.getFullYear()}-${String(this.date.getMonth() + 1).padStart(2, '0')}-${String(this.date.getDate()).padStart(2, '0')}`;
    this.router.navigate(['/flight-results'], {
      queryParams: { origin: originCity, destination: destinationCity, date: formattedDate }
    });
  }
}