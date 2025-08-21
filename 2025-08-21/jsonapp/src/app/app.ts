import { Component, signal } from '@angular/core';
import { VehicleComponent } from './vehicle/vehicle';

@Component({
  selector: 'app-root',
  imports: [VehicleComponent],
template: `
    <app-vehicle></app-vehicle>
  `
})
export class App {
  protected readonly title = signal('jsonapp');
}
