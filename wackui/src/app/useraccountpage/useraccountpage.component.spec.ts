import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UseraccountpageComponent } from './useraccountpage.component';

describe('UseraccountpageComponent', () => {
  let component: UseraccountpageComponent;
  let fixture: ComponentFixture<UseraccountpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UseraccountpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UseraccountpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
