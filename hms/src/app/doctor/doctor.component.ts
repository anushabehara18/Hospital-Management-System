import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from '../model/Doctor';
import { DoctorDataService } from '../service/data/doctor-data.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  id!:number
  doctor!:Doctor

  constructor(private doctorService:DoctorDataService, private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.doctor=new Doctor();
    if(this.id!=-1) {
    this.doctorService.retrieveDoctor(this.id).subscribe(
      data=>{
        this.doctor=data;
      }
    )
  }
}

  save(){
    if(this.id == -1) {
      //create doctor
      this.doctorService.createDoctor(this.doctor).subscribe(
        data=>{
          console.log(data);
          this.router.navigate(['list-doctors'])
        }
      )
    } else {
      //update doctor
    this.doctorService.updateDoctor(this.id,this.doctor).subscribe(
      data=>{
        console.log(data);
        this.router.navigate(['list-doctors'])
      }
    )
  }
}

}
