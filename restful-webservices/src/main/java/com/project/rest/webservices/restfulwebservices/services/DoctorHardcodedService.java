package com.project.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.rest.webservices.restfulwebservices.model.Doctor;

@Service
public class DoctorHardcodedService {
	
	private static List<Doctor> doctors=new ArrayList();
	private static int idCounter=0;
	
	static {
		doctors.add(new Doctor(++idCounter,"Anusha",22,"Female","Dermotologist"));
		doctors.add(new Doctor(++idCounter,"Anjali",30,"Female","Nutritionist"));
		doctors.add(new Doctor(++idCounter,"Aditya",35,"Male","Physician"));
	}
	
	public List<Doctor> findAll(){
		return doctors;
	}
	
	public Doctor deleteById(int id) {
		Doctor doctor=findById(id);
		if(doctor==null) return null;
		if(doctors.remove(doctor))
			return doctor;
		else
			return null;
	}

	public Doctor findById(int id) {
		for(Doctor doctor:doctors) {
			if(doctor.getId()==id)
				return doctor;
		}
		
		return null;
	}
	
	public Doctor save(Doctor doctor) {
		//if id=-1 create the new doctor else delete that doctor and add new doctor(update)
		if(doctor.getId()==-1 || doctor.getId()==0) {
			doctor.setId(++idCounter);
			doctors.add(doctor);
		}else {
			deleteById(doctor.getId());
			doctors.add(doctor);
		}
		return doctor;
	}
	
	

}
