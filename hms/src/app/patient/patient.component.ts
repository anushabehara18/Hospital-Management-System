import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/Patient';
import { PatientDataService } from '../service/data/patient-data.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  id!:number
  patient!:Patient
  
  constructor(private patientService:PatientDataService, private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.patient=new Patient();
    if(this.id!=-1) {
    this.patientService.retrievePatient(this.id).subscribe(
      data=>{
        this.patient=data;
      }
    )
  }
  }

  save(){
    if(this.id == -1) {
      //create patient
      this.patientService.createPatient(this.patient).subscribe(
        data=>{
          console.log(data);
          this.router.navigate(['list-patients'])
        }
      )
    } else {
      //update patient
    this.patientService.updatePatient(this.id,this.patient).subscribe(
      data=>{
        console.log(data);
        this.router.navigate(['list-patients'])
      }
    )
  }
}

}
