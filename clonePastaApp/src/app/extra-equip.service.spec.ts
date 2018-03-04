import { TestBed, inject } from '@angular/core/testing';

import { ExtraEquipService } from './extra-equip.service';

describe('ExtraEquipService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExtraEquipService]
    });
  });

  it('should be created', inject([ExtraEquipService], (service: ExtraEquipService) => {
    expect(service).toBeTruthy();
  }));
});
