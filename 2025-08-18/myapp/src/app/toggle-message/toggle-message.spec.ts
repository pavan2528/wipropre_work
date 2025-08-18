import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToggleMessage } from './toggle-message';

describe('ToggleMessage', () => {
  let component: ToggleMessage;
  let fixture: ComponentFixture<ToggleMessage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ToggleMessage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ToggleMessage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
