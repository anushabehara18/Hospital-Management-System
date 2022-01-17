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
import com.project.rest.webservices.restfulwebservices.services.PatientHardcodedService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PatientResource {
	
	@Autowired
	private PatientHardcodedService patientService;
	
	@GetMapping("/patients/")
	public List<Patient> getAllPatients(){
		return patientService.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable int id){
		return patientService.findById(id);
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable int id){
		Patient patient=patientService.deleteById(id);
		if(patient!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient patient){
		Patient patientUpdated = patientService.save(patient);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	
	@PostMapping("/patients/")
	public ResponseEntity<Void> updatePatient(@RequestBody Patient patient){
		Patient createdPatient = patientService.save(patient);
		
		//get current response url
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdPatient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
