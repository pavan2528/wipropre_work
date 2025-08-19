import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ex2ngclass',
  imports: [CommonModule],
  templateUrl: './ex2ngclass.component.html',
  styleUrl: './ex2ngclass.component.css'
})
export class Ex2ngclassComponent {
flag1 = true;
  flag2 = false;
}
