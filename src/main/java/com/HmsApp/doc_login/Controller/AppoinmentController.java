package com.HmsApp.doc_login.Controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HmsApp.doc_login.entity.Appoinments;
import com.HmsApp.doc_login.repository.AppoinmentsRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/appoin")
public class AppoinmentController
{
	
	@Autowired 
	private AppoinmentsRepository appoinrepos; //inject 
	
	@PostMapping("/insert_appoin")
	public Appoinments createappoinment(@RequestBody Appoinments appoinment) //
	{
		return appoinrepos.save(appoinment);
	}
	
	@GetMapping
	public List<Appoinments> getallrecords(Appoinments appoinment)
	{
		return appoinrepos.findAll() ;
		
	}
	
	@DeleteMapping("/delete_appoin/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException
	{
		Appoinments appoin=appoinrepos.findById(id). orElseThrow(()->new AttributeNotFoundException("Appointment not found with id"+id));
		appoinrepos.delete(appoin);
		 Map<String, Boolean> response = new HashMap<>();
	        response.put("Deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
	}
	
	
}
