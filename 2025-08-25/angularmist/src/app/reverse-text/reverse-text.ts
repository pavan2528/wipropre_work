import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from "@angular/material/input";

@Component({
  selector: 'app-reverse-text',
  imports: [ReactiveFormsModule, CommonModule, MatInputModule],
  templateUrl: './reverse-text.html',
  styleUrl: './reverse-text.css'
})
export class ReverseText {

  inputControl = new FormControl('');

  get reversedText(): string {
    return this.inputControl.value?.split('').reverse().join('') || '';
  }

}
