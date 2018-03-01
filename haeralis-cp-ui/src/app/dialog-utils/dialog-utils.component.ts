import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-dialog-utils',
  templateUrl: './dialog-utils.component.html',
  styleUrls: ['./dialog-utils.component.css']
})
export class DialogUtilsComponent implements OnInit {

  message: string;

  constructor(public dialog: MatDialog) {}

  openSimpleDialog(text: string): void {
    let dialogRef = this.dialog.open(SimpleMessageDialog, {
      width: '400px',
      data: { msg: text }
    });

    dialogRef.afterClosed().subscribe(result => {
     
    });
  }

  ngOnInit() {
  }

}

@Component({
  selector: 'app-dialog-utils-simple',
  templateUrl: 'dialog-utils-simple.component.html',
})
export class SimpleMessageDialog {

  constructor(
    public dialogRef: MatDialogRef<SimpleMessageDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

}