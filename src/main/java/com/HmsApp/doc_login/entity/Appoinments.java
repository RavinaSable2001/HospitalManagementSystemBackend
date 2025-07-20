package com.HmsApp.doc_login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appoinments")
public class Appoinments 
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  private String name;
  
  private int age;
  
  private String symptomps;
  
  private String mobileno;

public long getId() {
	return id;
}

public void setId(long id) {
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

public String getSymptomps() {
	return symptomps;
}

public void setSymptomps(String symptomps) {
	this.symptomps = symptomps;
}

public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}

public Appoinments(long id, String name, int age, String symptomps, String mobileno) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.symptomps = symptomps;
	this.mobileno = mobileno;
}

public Appoinments() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Appoinments [id=" + id + ", name=" + name + ", age=" + age + ", symptomps=" + symptomps + ", mobileno="
			+ mobileno + "]";
}

  
}
