package com.HmsApp.doc_login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicines")
public class Medicine
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	
	private String drugname;
	
	private String stock;

	public long getId()
	{
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Medicine(long id, String drugname, String stock) {
		super();
		this.id = id;
		this.drugname = drugname;
		this.stock = stock;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", drugname=" + drugname + ", stock=" + stock + "]";
	}
	

}
