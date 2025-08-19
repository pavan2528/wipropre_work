import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex4ngstyleComponent } from './ex4ngstyle.component';

describe('Ex4ngstyleComponent', () => {
  let component: Ex4ngstyleComponent;
  let fixture: ComponentFixture<Ex4ngstyleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex4ngstyleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex4ngstyleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
