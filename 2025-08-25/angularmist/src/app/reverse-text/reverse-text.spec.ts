import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReverseText } from './reverse-text';

describe('ReverseText', () => {
  let component: ReverseText;
  let fixture: ComponentFixture<ReverseText>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReverseText]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReverseText);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
