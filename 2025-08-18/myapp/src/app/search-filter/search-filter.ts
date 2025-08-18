import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-filter',
  imports: [CommonModule, FormsModule],
  templateUrl: './search-filter.html',
  styleUrl: './search-filter.css'
})
export class SearchFilter {

names: string[] = ["Jayanta", "Jayaram", "Amit", "Sneha", "Rahul", "Priya"];
  searchText: string = "";
  get filteredNames(): string[] {
    return this.names.filter(name =>
      name.toLowerCase().includes(this.searchText.toLowerCase())
    );
  
}
}

