import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CloneDetailComponent } from './clone-detail.component';

describe('CloneDetailComponent', () => {
  let component: CloneDetailComponent;
  let fixture: ComponentFixture<CloneDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CloneDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CloneDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
