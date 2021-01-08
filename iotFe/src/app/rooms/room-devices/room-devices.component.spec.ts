import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomDevicesComponent } from './room-devices.component';

describe('RoomDevicesComponent', () => {
  let component: RoomDevicesComponent;
  let fixture: ComponentFixture<RoomDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
