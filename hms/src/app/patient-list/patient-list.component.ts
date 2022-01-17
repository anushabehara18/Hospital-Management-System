import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../model/Patient';
import { PatientDataService } from '../service/data/patient-data.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  message:string='';

  patients:Patient[]=[]
  //   {id:1,name:'Carl',age:30,visitedDoctor:'Anusha',dateOfVisit:new Date},
  //   {id:2,name:'Pete',age:34,visitedDoctor:'Anjali',dateOfVisit:new Date},
  //   {id:3,name:'Jess',age:35,visitedDoctor:'Aditya',dateOfVisit:new Date}
  // ]
  
  constructor(private patientService:PatientDataService,private router:Router) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(){
    this.patientService.retrieveAllPatients().subscribe(
      response=>{
        console.log(response)
        this.patients=response;
      }
    )
  }

  deletePatient(id:number){
    this.patientService.deletePatient(id).subscribe(
      response=>{
        console.log(response);
        this.message='Deleted Successfully...!!!'
        this.refresh();
      }
    )
  }

  updatePatient(id:number){
    this.router.navigate(['patient',id]);
  }

  addPatient(){
    this.router.navigate(['patient',-1]);
  }

}
