import { LocationService } from './../../services/location.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Room } from 'app/models/room';
import { DeviceService } from 'app/services/device.service';

@Component({
  selector: 'app-add-device',
  templateUrl: './add-device.component.html',
  styleUrls: ['./add-device.component.css']
})
export class AddDeviceComponent implements OnInit {

  form = this.fb.group({
    
    name: ['', [Validators.required]],
    type : ['', [Validators.required]],
    maxValue : ['', [Validators.required]],
    minValue : ['', [Validators.required]],
    locationId: ['', [Validators.required]]
    
  });
  types: any = ['Ndricim', 'Ngrohje', 'Tech']
  rooms: Room[];
  constructor(private fb: FormBuilder,
              private roomService: LocationService,
              private deviceService: DeviceService) { }

  ngOnInit(): void {
    this.roomService.getAllRooms().subscribe(res=>{
      this.rooms = res;
    })
  }
  get type() {
    return this.form.get('type');
  }

  get locationId() {
    return this.form.get('locationId');
  }

  changeType(e) {
    console.log(e.target.value)
    this.type.setValue(e.target.value, {
      onlySelf: true
    })
  }

  changeRoom(e){
    console.log(e.target.value)
    this.locationId.setValue(e.target.value, {
      onlySelf: true
    })
  }

  onSubmit(){
    console.log(this.form.value)
    this.deviceService.addDevice(this.form.value).subscribe(res=>{
      console.log(res);
    })

  }

}
