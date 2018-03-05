import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CloneFormComponent } from './clone-form.component';

describe('CloneFormComponent', () => {
  let component: CloneFormComponent;
  let fixture: ComponentFixture<CloneFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CloneFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CloneFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
