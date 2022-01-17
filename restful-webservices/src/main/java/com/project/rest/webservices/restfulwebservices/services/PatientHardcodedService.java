package com.project.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.rest.webservices.restfulwebservices.model.Patient;

@Service
public class PatientHardcodedService {
	
	private static List<Patient> patients=new ArrayList();
	private static int idCounter=0;
	
	static {
		patients.add(new Patient(++idCounter,"Carl",22,"Anusha",new Date()));
		patients.add(new Patient(++idCounter,"Pete",30,"Anjali",new Date()));
		patients.add(new Patient(++idCounter,"Jess",35,"Aditya",new Date()));
	}
	
	public List<Patient> findAll(){
		return patients;
	}
	
	public Patient deleteById(int id) {
		Patient patient=findById(id);
		if(patient==null) return null;
		if(patients.remove(patient))
			return patient;
		else
			return null;
	}

	public Patient findById(int id) {
		for(Patient patient:patients) {
			if(patient.getId()==id)
				return patient;
		}
		
		return null;
	}
	
	public Patient save(Patient patient) {
		//if id=-1 create the new patient else delete that patient and add new patient(update)
		if(patient.getId()==-1 || patient.getId()==0) {
			patient.setId(++idCounter);
			patients.add(patient);
		}else {
			deleteById(patient.getId());
			patients.add(patient);
		}
		return patient;
	}
	
	
	

}
