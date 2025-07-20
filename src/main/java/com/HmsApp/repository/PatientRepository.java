package com.HmsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HmsApp.entity.Patient;

@Repository
public interface PatientRepository  extends JpaRepository<Patient ,Long>
{

}
