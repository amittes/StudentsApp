package com.example.studentsApp.model;

public class Student {
    public String name;
    public String id;
    public String avatarUrl;
    public Boolean cb;
    public String phoneNumber;
    public String address;

    public Student(String name, String id, String avatarUrl, Boolean cb, String phoneNumber, String address) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.cb = cb;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
