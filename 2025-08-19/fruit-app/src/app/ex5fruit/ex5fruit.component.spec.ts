import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex5fruitComponent } from './ex5fruit.component';

describe('Ex5fruitComponent', () => {
  let component: Ex5fruitComponent;
  let fixture: ComponentFixture<Ex5fruitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex5fruitComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex5fruitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
