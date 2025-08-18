import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-toggle-message',
  imports: [FormsModule],
  templateUrl: './toggle-message.html',
  styleUrl: './toggle-message.css'
})
export class ToggleMessage {
  // showMessage: boolean = false; 

  countries: string[] = ["India", "USA", "Germany", "Japan", "Canada"];
  dropdownCountries: string[] = [];
  loadCountries() {
    this.dropdownCountries = this.countries;
}

}
