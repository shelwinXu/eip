import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
//   template: `
//    <base href="/">
//   <mat-form-field appearance="fill">
//   <mat-label>Selected</mat-label>
//   <mat-select [(value)]="selectType">
//     <mat-option>None</mat-option>
//     <mat-option value="text">text</mat-option>
//     <mat-option value="image">image</mat-option>
//   </mat-select>
// </mat-form-field>

// <!-- <p>You selected: {{selectType}}</p> -->
// <input #newInput
//       (keyup.enter)="addInput(newInput.value)"
//       (blur)="addInput(newInput.value); newInput.value='' ">

//     <button (click)="addInput(newInput.value)"  >{{selectType}}</button>

//     <ul><li *ngFor="let input of inputs">{{input}}</li></ul>
//     <!-- <img *ngIf= "showImage" ng-src= "assets/images/garden.png"> -->
//     <img *ngIf= "showImage" src= "assets/images/garden.png">
//   `
})

export class AppComponent {
  // "imageUrl": "assets/images/garden_cart.png"
  selectType = 'None';
  inputs = [];
  showImage = false;
  addInput(newInput: string) {
    
    if (newInput && this.selectType === 'image') {
      this.showImage = true;
    } else {
      this.inputs.push(newInput);
    }
  }
}
