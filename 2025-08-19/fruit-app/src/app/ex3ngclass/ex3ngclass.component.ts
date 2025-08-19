import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-ex3ngclass',
  imports: [CommonModule],
  templateUrl: './ex3ngclass.component.html',
  styleUrl: './ex3ngclass.component.css'
})
export class Ex3ngclassComponent {
 flag1 = true;
  flag2 = false;

  getNgClass() {
    return {
      app1: this.flag1,
      app2: this.flag2
    };
  }


}
