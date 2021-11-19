import { TestBed } from '@angular/core/testing';

import { MenunService } from './menun.service';

describe('MenunService', () => {
  let service: MenunService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MenunService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
