import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Secondcomp } from './secondcomp/secondcomp'; 
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Secondcomp],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('firstapp');
}
