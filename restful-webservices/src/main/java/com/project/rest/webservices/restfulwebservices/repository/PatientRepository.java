package com.project.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.rest.webservices.restfulwebservices.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{

}
