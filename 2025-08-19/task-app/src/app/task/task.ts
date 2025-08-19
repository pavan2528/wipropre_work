import { Component, Input, Output, EventEmitter } from '@angular/core';
import { ITask } from '../itask';
@Component({
  selector: 'app-task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css'
})
export class Task {
@Input() task!: ITask;
  @Output() delete = new EventEmitter<number>();

  onDelete() {
    this.delete.emit(this.task.id);
  }
}
