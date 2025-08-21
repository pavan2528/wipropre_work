import { DatePipe, UpperCasePipe,  } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CelsiusToFahrenheitPipe } from './celsius-to-fahrenheit-pipe';
import { HighlightStrikethruDirective } from './highlight-strikethru';

@Component({
  selector: 'app-root',
  imports: [FormsModule, UpperCasePipe, DatePipe, CelsiusToFahrenheitPipe, HighlightStrikethruDirective],
  standalone: true,
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('newproject');
   text: string = '';
   selectedDate: Date | null = null; 
   temperatureC: number = 0;
}
