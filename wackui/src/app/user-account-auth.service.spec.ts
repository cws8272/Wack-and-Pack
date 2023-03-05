import { TestBed } from '@angular/core/testing';

import { UserAccountAuthService } from './user-account-auth.service';

describe('UserAccountAuthService', () => {
  let service: UserAccountAuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserAccountAuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
