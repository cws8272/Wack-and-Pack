import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupcompletepageComponent } from './signupcompletepage.component';

describe('SignupcompletepageComponent', () => {
  let component: SignupcompletepageComponent;
  let fixture: ComponentFixture<SignupcompletepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupcompletepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupcompletepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
