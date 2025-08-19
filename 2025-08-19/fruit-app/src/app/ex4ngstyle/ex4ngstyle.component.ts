import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-ex4ngstyle',
  imports: [CommonModule],
  templateUrl: './ex4ngstyle.component.html',
  styleUrl: './ex4ngstyle.component.css'
})
export class Ex4ngstyleComponent {
color1 = 'green';
  fontSize1 = '20px';
  flag1 = true;

  toggleColor() {
    this.flag1 = !this.flag1;
  }
}
