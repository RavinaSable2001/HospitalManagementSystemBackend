package com.HmsApp.doc_login.Controller;

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

import com.HmsApp.doc_login.entity.Medicine;
import com.HmsApp.doc_login.repository.MedicineRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/medicine")
public class MedicineController 
{
	
	@Autowired
	 private MedicineRepository medirepos;
	
	@PostMapping("/insert_medicine")
	public Medicine createmedicine(@RequestBody Medicine med)
	{
		return medirepos.save(med);
	}
	
	@GetMapping("/get_all_medicine")
	public List<Medicine> getallmedicine(Medicine med)
	{
		return medirepos.findAll();
	}
	
	@GetMapping("/medicine_byId/{id}")
	public ResponseEntity<Medicine>getMedicineById(@PathVariable long id) throws AttributeNotFoundException
	{
		 Medicine medicine=medirepos.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id"+id));
		return ResponseEntity.ok(medicine);
	}
	
	
	@PutMapping("/update_medicine/{id}")
	public ResponseEntity<Medicine>updatepatients(@PathVariable long id,@RequestBody Medicine medicinedetails) throws AttributeNotFoundException
	{
    	 Medicine medicine=medirepos.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine not found with id"+id));
	     medicine.setDrugname(medicinedetails.getDrugname());
	     medicine.setStock(medicinedetails.getStock());
	      
	     medirepos.save(medicine);
	     return ResponseEntity.ok(medicine);	
           	 
	}
	
	
	
	
	
	@DeleteMapping("/medicine_delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable long id) {
	    Medicine medicine = medirepos.findById(id)
	        .orElseThrow(() -> new RuntimeException("Medicine not found with id: " + id));

	    medirepos.delete(medicine);

	    Map<String,Boolean> response=new HashMap<>();
	   
	    response.put("deleted", Boolean.TRUE);
	    
	    return ResponseEntity.ok(response);
	}

	
}
