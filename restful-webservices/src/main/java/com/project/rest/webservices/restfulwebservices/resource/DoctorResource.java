package com.project.rest.webservices.restfulwebservices.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.rest.webservices.restfulwebservices.model.Doctor;
import com.project.rest.webservices.restfulwebservices.repository.DoctorRepository;
import com.project.rest.webservices.restfulwebservices.services.DoctorHardcodedService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DoctorResource {
	
	@Autowired
	private DoctorHardcodedService doctorService;

	
	@GetMapping("/doctors/")
	public List<Doctor> getAllDoctors(){
		return doctorService.findAll();
	}
	
	@GetMapping("/doctors/{id}")
	public Doctor getDoctors(@PathVariable int id){
		return doctorService.findById(id);
	}
	
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable int id){
		Doctor doctor=doctorService.deleteById(id);
		if(doctor!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int id,@RequestBody Doctor doctor){
		Doctor doctorUpdated = doctorService.save(doctor);
		return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
	}
	
	@PostMapping("/doctors/")
	public ResponseEntity<Void> updateDoctor(@RequestBody Doctor doctor){
		Doctor createdDoctor = doctorService.save(doctor);
		
		//get current response url
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdDoctor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
