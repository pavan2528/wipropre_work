import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex1HomeComponent } from './ex1-home.component';

describe('Ex1HomeComponent', () => {
  let component: Ex1HomeComponent;
  let fixture: ComponentFixture<Ex1HomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex1HomeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex1HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
