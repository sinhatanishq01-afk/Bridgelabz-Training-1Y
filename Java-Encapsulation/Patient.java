package com.gla.encapsulation;

public abstract class Patient {
    protected int patientId;
    protected String name;

    public Patient(int id, String name) {
        patientId = id;
        this.name = name;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient Name: " + name);
    }
}