import { Component } from '@angular/core';
import { ITask } from '../itask';
import { FormsModule } from '@angular/forms';
import { TaskList } from '../task-list/task-list';
import { CommonModule } from '@angular/common';
import { Task } from '../task/task';

@Component({
  selector: 'app-home',
  imports: [FormsModule, TaskList, CommonModule, Task],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

private nextId = Date.now();
  categories = ['Work', 'Study', 'Exercise', 'Personal', 'Shopping'];

  newDescription = '';
  newCategory = this.categories[0];

  tasks: ITask[] = [
    { id: this.getNextId(), description: 'Buy groceries', category: 'Shopping' },
    { id: this.getNextId(), description: 'Read chapter 4', category: 'Study' },
    { id: this.getNextId(), description: 'Morning run 3km', category: 'Exercise' }
  ];

  getNextId(): number {
    return ++this.nextId;
  }

  addTask() {
    const desc = this.newDescription?.trim();
    if (!desc) return;
    const task: ITask = { id: this.getNextId(), description: desc, category: this.newCategory };
    this.tasks = [task, ...this.tasks];
    this.newDescription = '';
    this.newCategory = this.categories[0];
  }

  removeTask(id: number) {
    this.tasks = this.tasks.filter(t => t.id !== id);
  }

}
