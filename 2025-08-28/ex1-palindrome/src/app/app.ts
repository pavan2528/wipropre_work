import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ex1-palindrome');

  isPalindrome(str: string): boolean {
    if (!str) return false;
    let clean = str.toLowerCase().replace(/[^a-z0-9]/g, ''); 
    return clean === clean.split('').reverse().join('');
  }

  add(a: number, b: number): number {
    return a + b;
  }

  multiply(a: number, b: number): number {
    return a * b;
  }
}
