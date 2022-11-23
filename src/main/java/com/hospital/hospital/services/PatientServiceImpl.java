package com.hospital.hospital.services;
import com.hospital.hospital.Dao.PatientDao;
import com.hospital.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientServices {

    @Autowired
    private PatientDao patientDao;

//    List<Patient> list;

    public PatientServiceImpl(){

//        list = new ArrayList<>();
//        list.add(new Patient(1,"Ritvik","rithvik@gmail.com"));
    }

    @Override
    public List<Patient> getPatients(){
        return patientDao.findAll();
    }

    @Override
    public Patient getPatient(Long patientId) {

//        Patient p = null;
//        for(Patient patient:list){
//            if(patient.getId()==patientId){
//                p=patient;
//                break;
//            }
//        }
        return patientDao.getReferenceById(patientId);
    }

    @Override
    public Patient addPatient(Patient patient) {
//        list.add(patient);
        patientDao.save(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(int id, Patient patient) throws IllegalArgumentException{
//        list.forEach(e ->{
//            if (e.getId()== patient.getId()){
//                e.setName(patient.getName());
//                e.setEmail(patient.getEmail());
//            }
//        });
        Patient patient1 = patientDao.getReferenceById(patient.getId());
        if(patient==null) throw new IllegalArgumentException("patient is null");
        patient1.setEmail(patient.getEmail());
        patient1.setName(patient.getName());
        patientDao.save(patient1);
        return patient1;
    }

    @Override
    public void deletePatient(long parseLong) {
//        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());

        Patient entity = patientDao.getOne(parseLong);
        patientDao.delete(entity);
    }
}
