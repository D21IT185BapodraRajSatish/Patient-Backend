package com.example.demo.controllers;

import com.example.demo.entinty.PatientRecord;
import com.example.demo.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PatientRecordController {


    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/patient")
    public List<PatientRecord> getAllPatient(){
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public PatientRecord getPatient(@PathVariable Long patientId ){
        return patientRecordRepository.findById(patientId).get();
    }

    @PostMapping("/patient")
    public String addPatient(@RequestBody PatientRecord patientRecord){
        Boolean  patientExists = patientRecordRepository.existsById(patientRecord.getPatientId());
        if(!patientExists) {
            patientRecordRepository.save(patientRecord);
            return "Patient Saved Successfully";
        }else {
            return "Patient already exists !!!";
        }
    }

    @PutMapping("/patient/{patientId}")
    public String updatePatient(@RequestBody PatientRecord patientRecord,@PathVariable Long patientId){
        PatientRecord patientRecord1 = patientRecordRepository.findById(patientId).get();
        patientRecord1.setName(patientRecord.getName());
        patientRecord1.setAddress(patientRecord.getAddress());
        patientRecord1.setAge(patientRecord.getAge());
        patientRecordRepository.save(patientRecord1);

        return "Record Updated Sucessfully";
    }

    @DeleteMapping("/patient/{patientId}")
    public String deletePatient(@PathVariable Long patientId){
        Boolean  patientExists = patientRecordRepository.existsById(patientId);
        if(patientExists) {
            patientRecordRepository.deleteById(patientId);
            return "Record Deleted Successfully";
        }else {
            return "Error Deleting Record";
        }
    }



}
