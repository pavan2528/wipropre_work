import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-switch-demo',
  imports: [FormsModule],
  templateUrl: './switch-demo.html',
  styleUrl: './switch-demo.css'
})
export class SwitchDemo {

//  colors: string[] = ["red", "blue", "green", "orange", "purple"];

//   selectedColor: string = "black";

//   changeColor(event: any) {
//     this.selectedColor = event.target.value;
// }

color: string = 'default';

}
