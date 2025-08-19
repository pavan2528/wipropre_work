import { Component, Input, EventEmitter, Output} from '@angular/core';
import { IFruit } from '../ifruit';
@Component({
  selector: 'app-ex5fruit',
  imports: [],
  templateUrl: './ex5fruit.component.html',
  styleUrl: './ex5fruit.component.css'
})
export class Ex5fruitComponent {
  @Input() fruit!: IFruit;
  @Output() removeFruit = new EventEmitter<string>();

  onRemove() {
    this.removeFruit.emit(this.fruit.name);
}
}
