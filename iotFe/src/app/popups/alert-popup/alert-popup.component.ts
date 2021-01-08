import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-alert-popup',
  templateUrl: './alert-popup.component.html',
  styleUrls: ['./alert-popup.component.css']
})
export class AlertPopupComponent implements OnInit {
  
  constructor(public dialogRef:MatDialogRef<AlertPopupComponent>) { }

  ngOnInit() {
  }
 
  closeDialog(){
    this.dialogRef.close();
  }

}
