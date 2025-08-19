import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ITask } from '../itask';
import { Task } from '../task/task';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-list',
  imports: [CommonModule, FormsModule],
  templateUrl: './task-list.html',
  styleUrl: './task-list.css'
})
export class TaskList {
  @Input() tasks: ITask[] = [];
  @Output() remove = new EventEmitter<number>();

  onRemoveTask(id: number) {
    this.remove.emit(id);
  }

  trackById(index: number, item: ITask) {
    return item.id;
  }
}
