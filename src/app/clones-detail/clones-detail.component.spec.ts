import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClonesDetailComponent } from './clones-detail.component';

describe('ClonesDetailComponent', () => {
  let component: ClonesDetailComponent;
  let fixture: ComponentFixture<ClonesDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClonesDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClonesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
