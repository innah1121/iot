import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Device } from 'app/models/device';
import { Room } from 'app/models/room';
import { AlertPopupComponent } from 'app/popups/alert-popup/alert-popup.component';
import { DeviceService } from 'app/services/device.service';
import { interval } from 'rxjs';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-room-devices',
  templateUrl: './room-devices.component.html',
  styleUrls: ['./room-devices.component.css']
})
export class RoomDevicesComponent implements OnInit {
  
  devices: Device[];
  actualPower: number;
  showAlert : boolean = false;
  constructor(private route: ActivatedRoute,
              private deviceService: DeviceService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    interval(10000).subscribe(x => {
      console.log("power getting taken");
      this.getActualPower();
    });
    this.route.queryParams.subscribe(data => {
      console.log(data);
      console.log("this id is" + data.id);
      this.deviceService.getRoomDevices(data.id).pipe(first()).subscribe(res=>{
        this.devices = res as Device[];
        console.log(res)
      })
    });
  }

  getActualPower(){
    this.deviceService.getTotalPower().subscribe(data=>{
      this.actualPower = data;
      if(this.actualPower >= 2000) {
        this.showAlert = true;
        this.openDialog();
      }
      else {
        this.showAlert = false;
      }
    });
  }
  clickEventHandler(device:Device,event: any){
    let state :string;
    console.log(event.target.checked);
    console.log(device)
    if(event != null) {
       state = event.target.checked ? 'ON' : 'OFF'
       console.log(state);
       device.state = state;
       console.log(device)
       this.deviceService.editDevice(device).pipe(first()).subscribe(res=>{
        console.log(res);
       })
    }
 }

 openDialog(): void {
  const dialogRef = this.dialog.open(AlertPopupComponent, {});

  dialogRef.afterClosed().subscribe(result => {
    console.log('The dialog was closed');
    console.log(result);
  });

}

}
