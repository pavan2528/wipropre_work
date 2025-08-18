import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

interface Book {
  title: string;
  description: string;
  image: string;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class Home {
  books: Book[] = Array.from({ length: 20 }, (_, i) => ({
    title: `Book Title ${i + 1}`,
    description: `This is a short description of Book ${i + 1}.`,
    image: `https://via.placeholder.com/120x160?text=Book+${i + 1}`
  }));
}
