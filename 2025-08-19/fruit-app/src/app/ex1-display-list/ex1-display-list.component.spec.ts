import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex1DisplayListComponent } from './ex1-display-list.component';

describe('Ex1DisplayListComponent', () => {
  let component: Ex1DisplayListComponent;
  let fixture: ComponentFixture<Ex1DisplayListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex1DisplayListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex1DisplayListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
