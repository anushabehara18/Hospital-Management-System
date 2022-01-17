import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http'
import { Doctor } from 'src/app/model/Doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorDataService {
  
  constructor(private http:HttpClient) { }

  retrieveAllDoctors(){
    
    return this.http.get<Doctor[]>('http://localhost:8080/jpa/doctors/')
  }

  deleteDoctor(id:number){
    return this.http.delete(`http://localhost:8080/jpa/doctors/${id}`);
  }

  retrieveDoctor(id:number){
    return this.http.get<Doctor>(`http://localhost:8080/jpa/doctors/${id}`);
  }

  updateDoctor(id:number,doctor:Doctor){
    return this.http.put(`http://localhost:8080/jpa/doctors/${id}`,doctor);
  }

  createDoctor(doctor:Doctor){
    return this.http.post(`http://localhost:8080/jpa/doctors/`,doctor);
  }

 
}
