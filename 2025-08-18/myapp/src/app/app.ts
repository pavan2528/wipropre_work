import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Home } from './home/home';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Home],
  // templateUrl: './app.html',
  // styleUrl: './app.css'
   template: `<app-home></app-home>`,
})
export class App {
  // protected readonly title = signal('myapp');
  // // myMessage: string = 'Hello Angular! This string is coming from app.component.ts';

  // // greet() {
  // //   console.log('Hello ' + (this.myMessage));
  // // }

  // names: string[] = ["Ravi", "Sneha", "pavan", "Priya", "kiran"];
}
