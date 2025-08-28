import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatStepperModule } from '@angular/material/stepper';

@Component({
  selector: 'app-stepper-form',
  imports: [ReactiveFormsModule, MatStepperModule, MatInputModule, MatInputModule],
  templateUrl: './stepper-form.html', 
  styleUrl: './stepper-form.css',
  standalone: true

})
export class StepperForm {
  nameForm;
  ageForm;
  emailForm;

  constructor(private fb: FormBuilder) {
 this.nameForm = this.fb.group({
    name: ['', Validators.required]
  });
 this.ageForm = this.fb.group({
    age: ['', [Validators.required, Validators.min(1), Validators.max(120)]]
  });
 this.emailForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]]
  });
  }

  submit() {
    console.log("Form Submitted");
    console.log("Name:", this.nameForm.value.name);
    console.log("Age:", this.ageForm.value.age);
    console.log("Email:", this.emailForm.value.email);
    alert("Form submitted successfully!");
  }

}
