import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import { ThreadListComponent } from './threads/thread.list.component';
import { ThreadComponent } from './threads/thread.component';
import {LoginComponent} from "./auth/login/login.component";
import {RegisterComponent} from "./auth/register/registration.component";
import {ForgotPassword2Component, ForgotPasswordStep1Component} from "./auth/forgot/forgotPassword.component";
import {LogoutComponent, RegistrationConfirmationComponent} from "./auth/confirm/confirmRegistration.component";
import {ResendCodeComponent} from "./auth/resend/resendCode.component";
import {NewPasswordComponent} from "./auth/newpassword/newpassword.component";

const appRoutes: Routes = [
  { path: 'thread/:id', component: ThreadComponent },
  { path: 'threads',      component: ThreadListComponent },
    {path: 'logout', component: LogoutComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'confirmRegistration/:username', component: RegistrationConfirmationComponent},
    {path: 'resendCode', component: ResendCodeComponent},
    {path: 'forgotPassword/:email', component: ForgotPassword2Component},
    {path: 'forgotPassword', component: ForgotPasswordStep1Component},
    {path: 'newPassword', component: NewPasswordComponent},
    {path: 'register', component: RegisterComponent},
      { path: '', component : HomeComponent },
  { path: '**', component: HomeComponent },
];

const routes: Routes = [
    {
        path: '',
        children: [
        ]
    },
];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);