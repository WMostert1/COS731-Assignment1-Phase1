import { Component } from '@angular/core';
import {CognitoUtil} from './service/cognito.service';
import { CognitoUser } from "amazon-cognito-identity-js";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    constructor(private cognitoUtil : CognitoUtil){}

     getEmail() : string {
       let  user : CognitoUser =  this.cognitoUtil.getCurrentUser();
       if (user == null) return null;
  
       return user.getUsername();
     }
}
