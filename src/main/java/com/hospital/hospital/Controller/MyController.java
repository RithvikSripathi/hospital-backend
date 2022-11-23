package com.hospital.hospital.Controller;

import com.hospital.hospital.entities.Patient;
import com.hospital.hospital.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MyController {

    @Autowired
    private PatientServices patientServices;



    @CrossOrigin
    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return this.patientServices.getPatients();


    }

    @CrossOrigin
    @GetMapping("/paitents/{patientId}")
    public Patient getPatient(@PathVariable String patientId){
        return this.patientServices.getPatient(Long.parseLong(patientId));
    }

    @CrossOrigin
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient){

        return this.patientServices.addPatient(patient);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient){
        return this.patientServices.updatePatient(id,patient);
    }

    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable String patientId){
        try{
            this.patientServices.deletePatient(Long.parseLong(patientId));
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
