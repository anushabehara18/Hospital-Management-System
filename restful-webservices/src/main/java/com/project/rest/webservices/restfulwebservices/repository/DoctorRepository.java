package com.project.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.rest.webservices.restfulwebservices.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

}
