import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorInfoComponent } from './doctor-info/doctor-info.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { DoctorComponent } from './doctor/doctor.component';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PatientInfoComponent } from './patient-info/patient-info.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientComponent } from './patient/patient.component';
import { RouteGaurdService } from './service/route-gaurd.service';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  // for default route
  { path: '', component:LoginComponent },
  // for login component
  { path: 'login', component:LoginComponent },
  // for welcome component with names 
  { path: 'welcome/:name', component: WelcomeComponent , canActivate:[RouteGaurdService]},
  { path: 'list-doctors', component: DoctorListComponent ,canActivate:[RouteGaurdService]},
  { path: 'list-patients', component: PatientListComponent,canActivate:[RouteGaurdService] },
  { path: 'show-doctor', component: DoctorInfoComponent ,canActivate:[RouteGaurdService]},
  { path: 'show-patient', component: PatientInfoComponent,canActivate:[RouteGaurdService] },
  { path: 'logout',component: LogoutComponent,canActivate:[RouteGaurdService] },
  { path: 'patient/:id',component: PatientComponent,canActivate:[RouteGaurdService] },
  { path: 'doctor/:id',component: DoctorComponent,canActivate:[RouteGaurdService] },
  // for error page
  { path: '**', component:ErrorComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
