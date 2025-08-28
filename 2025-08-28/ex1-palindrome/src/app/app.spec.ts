import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { App } from './app';

describe('AppComponent Test Suite', () => {
  let component: App

  // runs before every test
  beforeEach(() => {
    component = new App();
  });

  it('Test Case1: sanity check', () => {
    expect(1 == 1).toBe(true);
  });

  it('Test Case2: add function', () => {
    let value = component.add(2, 3);
    expect(value).toEqual(5);
  });

  it('Test Case3: multiply function', () => {
    let value = component.multiply(2, 3);
    expect(value).toEqual(6);
  });

  it('Palindrome check: madam', () => {
    expect(component.isPalindrome('madam')).toBeTrue();
  });

  it('Palindrome check: racecar', () => {
    expect(component.isPalindrome('racecar')).toBeTrue();
  });

  it('Not palindrome: hello', () => {
    expect(component.isPalindrome('hello')).toBeFalse();
  });

  it('Palindrome check with spaces & caps: "A man a plan a canal Panama"', () => {
    expect(component.isPalindrome('A man a plan a canal Panama')).toBeTrue();
  });
});
