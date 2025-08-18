import { Component } from '@angular/core';

@Component({
  selector: 'app-demo',
  imports: [],
  standalone: true,
  // templateUrl: './demo.html',
  // styleUrl: './demo.css',
  template: `
    <div class="d-flex justify-content-center align-items-center vh-100 bg-light">
      <div class="card shadow p-4" style="width: 350px;">
        <h3 class="text-center mb-3">Demo Component</h3>
        <p class="text-center text-muted">This component is using inline template!</p>
      </div>
    </div>
  `,
  styles: [`
    h3 {
      color: #007bff;
    }
  `]
})
export class Demo {

}
