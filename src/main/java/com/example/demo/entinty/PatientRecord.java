package com.example.demo.entinty;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity


public class PatientRecord {
    @Id
    private Long patientId;
    private String name;
    private Integer age;
    private String address;


    public PatientRecord(Long patientId, String name, Integer age, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public PatientRecord() {
    }



    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
