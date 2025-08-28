import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepperForm } from './stepper-form';

describe('StepperForm', () => {
  let component: StepperForm;
  let fixture: ComponentFixture<StepperForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StepperForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StepperForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
