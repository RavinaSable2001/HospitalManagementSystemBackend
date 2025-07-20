package com.HmsApp.doc_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HmsApp.doc_login.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Long>
{

}
