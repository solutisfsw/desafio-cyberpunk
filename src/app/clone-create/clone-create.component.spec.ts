import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CloneCreateComponent } from './clone-create.component';

describe('CloneCreateComponent', () => {
  let component: CloneCreateComponent;
  let fixture: ComponentFixture<CloneCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CloneCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CloneCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
