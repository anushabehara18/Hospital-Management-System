package com.project.rest.webservices.restfulwebservices.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@GeneratedValue
	@Column(name="doctor_id")
	private int id;
	@Column(name="doctor_name")
	private String name;
	@Column(name="doctor_age")
	private int age;
	@Column(name="doctor_gender")
	private String gender;
	@Column(name="doctor_field")
	private String field;
	
	
	protected Doctor() {
		
	}
	
	public Doctor(int id, String name, int age, String gender, String field) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.field = field;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return id == other.id;
	}
	
	
	
	

}
