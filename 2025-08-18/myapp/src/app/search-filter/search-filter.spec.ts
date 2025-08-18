import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-filter',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './search-filter.html',
  styleUrls: ['./search-filter.css']
})
export class SearchFilterComponent {
  names: string[] = ["Jayanta", "Jayaram", "Amit", "Sneha", "Rahul", "Priya"];

  searchText: string = "";

  get filteredNames(): string[] {
    return this.names.filter(name =>
      name.toLowerCase().startsWith(this.searchText.toLowerCase())
    );
  }
}
