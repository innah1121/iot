import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Room, RoomDevices } from 'app/models/room';
import { AlertPopupComponent } from 'app/popups/alert-popup/alert-popup.component';
import { DeviceService } from 'app/services/device.service';
import { LocationService } from 'app/services/location.service';
import { interval } from 'rxjs';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {

  noRooms: number;
  actualPower: number;
  rooms: Room[];
  noDevice: number;
  roomDevice : RoomDevices;
  roomDevices : RoomDevices[] = [];
  showAlert : boolean = false;
  constructor(private roomService : LocationService,
              private deviceService: DeviceService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
   
    this.roomService.getAllRooms().pipe(first()).subscribe(res=>{
      this.rooms = res;
      // res.forEach(room =>{
      //   this.deviceService.getRoomDevices(room.id).subscribe(devices=>{
      //     this.roomDevice = new RoomDevices();
      //     console.log(devices.length)
      //     console.log(room.name)
      //     this.roomDevice.name = room.name;
      //     this.roomDevice.noDevices = devices.length;
      //     console.log(this.roomDevice.name)
      //     console.log("devices number + room"+ this.roomDevice);
      //     this.roomDevices.push(this.roomDevice);
      //   })
      //})
    });
    
    this.roomService.getTotalNoOfRooms().pipe(first()).subscribe(res=>{
      this.noRooms = res;
      console.log(this.noRooms);
    });

    this.deviceService.getTotalPower().subscribe(data=>{
      this.actualPower = data;
    });

    interval(10000).subscribe(x => {
      console.log("power getting taken");
      this.getActualPower();
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

  openDialog(): void {
    const dialogRef = this.dialog.open(AlertPopupComponent, {
      
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
    });
  
  }

}
