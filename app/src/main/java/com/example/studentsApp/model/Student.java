package com.example.studentsApp.model;

public class Student {
    private String name;
    private String id;
    private String phone;
    private String address;
    private String avatarUrl;
    private Boolean cb;

    public Student(String name, String id, String phone, String address, Boolean cb) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.avatarUrl = "";
        this.cb = cb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getCb() {
        return cb;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
    }
}
