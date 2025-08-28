import { Component, signal } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { StepperForm } from './stepper-form/stepper-form';
import { ReverseText } from './reverse-text/reverse-text';
import { RegistrationForm } from './registration-form/registration-form';

@Component({
  selector: 'app-root',
  imports: [MatListModule, StepperForm, ReverseText, RegistrationForm],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('angularmist');
  cities: string[] = [
    'Delhi',
    'Mumbai',
    'Bengaluru',
    'Chennai',
    'Hyderabad',
    'Kolkata',
    'Pune'
  ];
}
