import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex3ngclassComponent } from './ex3ngclass.component';

describe('Ex3ngclassComponent', () => {
  let component: Ex3ngclassComponent;
  let fixture: ComponentFixture<Ex3ngclassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex3ngclassComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex3ngclassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
