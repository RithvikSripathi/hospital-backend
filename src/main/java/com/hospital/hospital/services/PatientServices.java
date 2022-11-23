package com.hospital.hospital.services;

import com.hospital.hospital.entities.Patient;

import java.util.List;

public interface PatientServices {
    public List<Patient> getPatients();
    public  Patient getPatient(Long patientId);

    public Patient addPatient(Patient patient);

    public Patient updatePatient(int id,Patient patient);

    public void deletePatient(long parseLong);


}
