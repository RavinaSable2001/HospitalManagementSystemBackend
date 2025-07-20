package com.HmsApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HmsApp.entity.Patient;
import com.HmsApp.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200") // Allow Angular requests
@RestController
@RequestMapping("/api/patients")
public class PatientsController
{

	@Autowired
	private PatientRepository patientrepos;
	
	@PostMapping("/insert")
	public Patient createpatient( @RequestBody Patient patient)
	{
		return patientrepos.save(patient);
	}
	

	@GetMapping("/get_patients")
	public List<Patient> getall_patients(Patient patient)
	{
		
		return patientrepos.findAll();
		
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id)throws  AttributeNotFoundException
	{
	   Patient patient1=patientrepos.findById(id).orElseThrow(()->new AttributeNotFoundException("patients not found with id:"+id));
	   return ResponseEntity.ok(patient1); 
	}
	
	@PutMapping("/update_patients/{id}")
	public ResponseEntity<Patient> updatePatientbyId(@PathVariable long id, @RequestBody Patient patientDetails) throws AttributeNotFoundException
	{
		
		Patient patient= patientrepos.findById(id).orElseThrow(()->new AttributeNotFoundException("patient not found with id"+id));
		patient.setAge(patientDetails.getAge());
		patient.setName(patientDetails.getName());
		patient.setBlood(patientDetails.getBlood());
		
		patient.setDoes(patientDetails.getDoes());
		patient.setFees(patientDetails.getFees());
		patient.setPrescription(patientDetails.getPrescription());
		patient.setUrgency(patientDetails.getUrgency());
		
	  Patient savePatient=patientrepos.save(patient);
	  return ResponseEntity.ok(savePatient);
		
		  
		
		
	}
	
	
	@DeleteMapping("/delete_patients/{id}")
	public ResponseEntity<Map<String,Boolean>>deletepatient(@PathVariable long id) throws AttributeNotFoundException
	{
		  Patient patient= patientrepos.findById(id).orElseThrow(()->new AttributeNotFoundException("patient not found with id"+id));
		  patientrepos.delete(patient);
		  
		    Map<String, Boolean> response = new HashMap<>();
	        response.put("Deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
		
		 
	}
}
