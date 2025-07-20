package com.HmsApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patients")
public class Patient
{

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	 
	 @Column(name="first_name")
	 private String name;
	 
	 @Column(name="age")
	 private int age;
	 
	 @Column(name="blood_group")
	 private String blood;
	 
	 @Column(name="prescription")
	 private String prescription;
	 
	 @Column(name="dose")
	 private String does;
	 
	 @Column(name="fees")
	 private String fees;
	 
	 @Column(name="urgency")
	 private String urgency;

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

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getDoes() {
		return does;
	}

	public void setDoes(String does) {
		this.does = does;
	}

	public String getFees() {
		return fees;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", blood=" + blood + ", prescription="
				+ prescription + ", does=" + does + ", fees=" + fees + ", urgency=" + urgency + "]";
	}

	public Patient() {
		super();
		
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public Patient(long id, String name, int age, String blood, String prescription, String does, String fees,
			String urgency) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.blood = blood;
		this.prescription = prescription;
		this.does = does;
		this.fees = fees;
		this.urgency = urgency;
	}
	 
	 
}
