import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ex1HomeComponent } from './ex1-home/ex1-home.component';
import { Ex2ngclassComponent } from './ex2ngclass/ex2ngclass.component';
import { Ex3ngclassComponent } from './ex3ngclass/ex3ngclass.component';
import { Ex4ngstyleComponent } from './ex4ngstyle/ex4ngstyle.component';

@Component({
  selector: 'app-root',
  imports: [Ex1HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'thirdapp';
}
