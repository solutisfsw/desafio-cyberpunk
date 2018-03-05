import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClonesCreateComponent } from './clones-create.component';

describe('ClonesCreateComponent', () => {
  let component: ClonesCreateComponent;
  let fixture: ComponentFixture<ClonesCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClonesCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClonesCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
