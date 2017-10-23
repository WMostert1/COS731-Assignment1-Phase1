import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ThreadComponent } from './threads/thread.component';
import { PostComponent } from './threads/posts/post.component';
import { ThreadListComponent } from './threads/thread.list.component';
import { HomeComponent } from './home/home.component';

import { ThreadService } from './threads/thread.service';

import { RouterModule, Routes } from '@angular/router';


//---------------------------------------------------
import { HttpModule } from "@angular/http";
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { UserRegistrationService } from "./service/user-registration.service";
import { UserParametersService } from "./service/user-parameters.service";
import { UserLoginService } from "./service/user-login.service";
import { CognitoUtil } from "./service/cognito.service";

import { AwsUtil } from "./service/aws.service";

import { LoginComponent } from "./auth/login/login.component";
import { RegisterComponent } from "./auth/register/registration.component";
import { ForgotPassword2Component, ForgotPasswordStep1Component } from "./auth/forgot/forgotPassword.component";
import { LogoutComponent, RegistrationConfirmationComponent } from "./auth/confirm/confirmRegistration.component";
import { ResendCodeComponent } from "./auth/resend/resendCode.component";
import { NewPasswordComponent } from "./auth/newpassword/newpassword.component";


import { routing } from './app.routes';
import { ConfirmationDialog } from "./confirm-dialog/confirmation-dialog";

import { MaterialModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ToastModule} from 'ng2-toastr/ng2-toastr';


@NgModule({
  declarations: [
    AppComponent,
    ThreadComponent,
    ThreadListComponent,
    HomeComponent,
    PostComponent,
    NewPasswordComponent,
    LoginComponent,
    LogoutComponent,
    RegistrationConfirmationComponent,
    ResendCodeComponent,
    ForgotPasswordStep1Component,
    ForgotPassword2Component,
    RegisterComponent,
    HomeComponent,
    AppComponent,
    ConfirmationDialog
  ],
  imports: [
    BrowserModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    ReactiveFormsModule,
    routing,
    MaterialModule,
    BrowserAnimationsModule,
    ToastModule.forRoot()
  ],
  providers: [ThreadService,
    CognitoUtil,
    AwsUtil,
    UserRegistrationService,
    UserLoginService,
    UserParametersService],
  entryComponents: [ConfirmationDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
