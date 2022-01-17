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
import com.project.rest.webservices.restfulwebservices.model.Patient;
import com.project.rest.webservices.restfulwebservices.repository.DoctorRepository;
import com.project.rest.webservices.restfulwebservices.repository.PatientRepository;
import com.project.rest.webservices.restfulwebservices.services.PatientHardcodedService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PatientJpaResource {
	
	@Autowired
	private PatientRepository pr;
	
	@GetMapping("/jpa/patients/")
	public List<Patient> getAllPatients(){
		return pr.findAll();
	}
	
	@GetMapping("/jpa/patients/{id}")
	public Patient getPatient(@PathVariable int id){
		return pr.findById(id).get();
	}
	
	@DeleteMapping("/jpa/patients/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable int id){
		pr.deleteById(id);
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/jpa/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient patient){
		Patient patientUpdated = pr.save(patient);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	
	@PostMapping("/jpa/patients/")
	public ResponseEntity<Void> createPatient(@RequestBody Patient patient){
		Patient createdPatient = pr.save(patient);
		
		//get current response url
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdPatient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
