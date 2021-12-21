import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import {RegisterComponent} from './register/register.component'
import { ProfileComponent } from './profile/profile.component';


const routes: Routes = [ { path:'', component: EmployeeComponent},
{ path:'addemployee', component: AddEmployeeComponent },
{ path: 'login', component: LoginComponent},
{ path: 'register', component: RegisterComponent},
{ path: 'profile', component: ProfileComponent},
{ path: 'logout', component: LogoutComponent},];

@NgModule({

  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
