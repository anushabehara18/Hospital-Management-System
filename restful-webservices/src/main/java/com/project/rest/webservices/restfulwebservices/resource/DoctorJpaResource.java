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
public class DoctorJpaResource {
	
	@Autowired
	private DoctorRepository dr;

	
	@GetMapping("/jpa/doctors/")
	public List<Doctor> getAllDoctors(){
		//return doctorService.findAll();
		return dr.findAll();
	}
	
	@GetMapping("/jpa/doctors/{id}")
	public Doctor getDoctors(@PathVariable int id){
		return dr.findById(id).get();
	}
	
	@DeleteMapping("/jpa/doctors/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable int id){
		dr.deleteById(id);
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/jpa/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int id,@RequestBody Doctor doctor){
		Doctor doctorUpdated = dr.save(doctor);
		return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
	}
	
	@PostMapping("/jpa/doctors/")
	public ResponseEntity<Void> createDoctor(@RequestBody Doctor doctor){
		Doctor createdDoctor = dr.save(doctor);
		
		//get current response url
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdDoctor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
