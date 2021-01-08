import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Device } from 'app/models/device';
import { AlertPopupComponent } from 'app/popups/alert-popup/alert-popup.component';
import { DeviceService } from 'app/services/device.service';
import { interval } from 'rxjs';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})
export class DevicesComponent implements OnInit {
  
  noDevices: number;
  noOnDevices: number;
  actualPower: number;
  devices: Device[];
  showAlert : boolean = false;
  constructor(private deviceService: DeviceService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.deviceService.getAllDevices().pipe(first()).subscribe(res=>{
      this.devices = res;

    });


    this.deviceService.getTotalNoOfDevices().pipe(first()).subscribe(res=>{
      this.noDevices = res;
      console.log(this.noDevices);
    });

    this.deviceService.getTotalNoOfDevicesON().pipe(first()).subscribe(res=>{
      this.noOnDevices = res;
      console.log(this.noOnDevices);
    });

    
    interval(10000).subscribe(x => {
      console.log("power getting taken");
      this.getActualPower();
    });

    this.deviceService.getTotalPower().subscribe(data=>{
      this.actualPower = data;
     });
  }

  getActualPower(){
    this.deviceService.getTotalPower().subscribe(data=>{
      let power ;
      power = data;
      if(power >= 2000) {
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
