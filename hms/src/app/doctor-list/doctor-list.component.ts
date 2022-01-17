import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../model/Doctor';
import { DoctorDataService } from '../service/data/doctor-data.service';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  message:string='';
  doctors:Doctor[]=[]
 
  // =[
  //   {id:1,name:'Anjali',age:30,gender:'Female',field:'Nutritionist'},
  //   {id:2,name:'Anusha',age:34,gender:'Female',field:'Dermotologist'},
  //   {id:3,name:'Aditya',age:35,gender:'Male',field:'Radiologist'}
  // ]

  constructor(private doctorService:DoctorDataService, private router:Router) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(){
    this.doctorService.retrieveAllDoctors().subscribe(
      response=>{
        console.log(response)
        this.doctors=response;
      }
    )
  }

  deleteDoctor(id:number){
    this.doctorService.deleteDoctor(id).subscribe(
      response=>{
        console.log(response);
        this.message='Deleted Successfully...!!!'
        this.refresh();
      }
    )
  }

  updateDoctor(id:number){
    this.router.navigate(['doctor',id]);
  }

  addDoctor(){
    this.router.navigate(['doctor',-1]);
  }

}


