import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClonesEditComponent } from './clones-edit.component';

describe('ClonesEditComponent', () => {
  let component: ClonesEditComponent;
  let fixture: ComponentFixture<ClonesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClonesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClonesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
