import { TestBed } from '@angular/core/testing';

import { DoacaorecebidaService } from './doacaorecebida.service';

describe('DoacaorecebidaService', () => {
  let service: DoacaorecebidaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoacaorecebidaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
