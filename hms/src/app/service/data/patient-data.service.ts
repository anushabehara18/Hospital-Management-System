import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from 'src/app/model/Patient';

@Injectable({
  providedIn: 'root'
})
export class PatientDataService {

  constructor(private http:HttpClient) { }

  retrieveAllPatients(){
    return this.http.get<Patient[]>('http://localhost:8080/jpa/patients/')
  }
  deletePatient(id:number){
    return this.http.delete(`http://localhost:8080/jpa/patients/${id}`);
  }

  retrievePatient(id:number){
    return this.http.get<Patient>(`http://localhost:8080/jpa/patients/${id}`);
  }

  updatePatient(id:number,patient:Patient){
    return this.http.put(`http://localhost:8080/jpa/patients/${id}`,patient);
  }

  createPatient(patient:Patient){
    return this.http.post(`http://localhost:8080/jpa/patients/`,patient);
  }
}
