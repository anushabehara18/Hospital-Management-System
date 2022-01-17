import { TestBed } from '@angular/core/testing';

import { HardcodedAutenticationService } from './hardcoded-autentication.service';

describe('HardcodedAutenticationService', () => {
  let service: HardcodedAutenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HardcodedAutenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
