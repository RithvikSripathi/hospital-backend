package com.hospital.hospital.Dao;

import com.hospital.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patient,Long> {
}
