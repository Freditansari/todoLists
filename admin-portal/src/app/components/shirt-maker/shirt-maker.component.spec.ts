import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShirtMakerComponent } from './shirt-maker.component';

describe('ShirtMakerComponent', () => {
  let component: ShirtMakerComponent;
  let fixture: ComponentFixture<ShirtMakerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShirtMakerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShirtMakerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
