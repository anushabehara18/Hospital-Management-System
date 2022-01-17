import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/Patient';
import { PatientDataService } from '../service/data/patient-data.service';

@Component({
  selector: 'app-patient-info',
  templateUrl: './patient-info.component.html',
  styleUrls: ['./patient-info.component.css']
})
export class PatientInfoComponent implements OnInit {

  id!: number;
  selectedPatient=new Patient;
  patients:Patient[]=[];
  isSelectedPatient:boolean = false;
  constructor(private patientService:PatientDataService) { }

  ngOnInit(): void {
    this.patientService.retrieveAllPatients().subscribe(
      response=>{
        console.log(response)
        this.patients=response;
      }
    )

  }


  onSelect(id:any){
    this.patientService.retrievePatient(this.selectedPatient.id).subscribe(
      response=>{
        console.log(response)
        this.isSelectedPatient = true
        this.selectedPatient=response
      }
    )
  }

}
