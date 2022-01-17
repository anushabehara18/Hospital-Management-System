import { Component, OnInit } from '@angular/core';
import { Doctor } from '../model/Doctor';
import { DoctorDataService } from '../service/data/doctor-data.service';

@Component({
  selector: 'app-doctor-info',
  templateUrl: './doctor-info.component.html',
  styleUrls: ['./doctor-info.component.css']
})
export class DoctorInfoComponent implements OnInit {

  
  id!: number;
  selectedDoctor=new Doctor;
  doctors:Doctor[]=[];
  constructor(private doctorService:DoctorDataService) { }

  ngOnInit(): void {
    this.doctorService.retrieveAllDoctors().subscribe(
      response=>{
        console.log(response)
        this.doctors=response;
      }
    )

  }


  onSelect(id:any){
    this.doctorService.retrieveDoctor(this.selectedDoctor.id).subscribe(
      response=>{
        console.log(response)
        this.selectedDoctor=response
        
      }
    )
  }

}
