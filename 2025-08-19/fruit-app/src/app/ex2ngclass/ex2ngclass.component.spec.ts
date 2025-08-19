import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex2ngclassComponent } from './ex2ngclass.component';

describe('Ex2ngclassComponent', () => {
  let component: Ex2ngclassComponent;
  let fixture: ComponentFixture<Ex2ngclassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex2ngclassComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex2ngclassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
