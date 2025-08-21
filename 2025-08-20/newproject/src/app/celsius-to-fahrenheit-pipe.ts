import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'celsiusToFahrenheit'
})
export class CelsiusToFahrenheitPipe implements PipeTransform {

  transform(value: number): string {
    if (value == null) return '';
    let fahrenheit = (value * 9 / 5) + 32;
    return `${fahrenheit}F`;
  }
}
