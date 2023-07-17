/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Thuy
 */
public class Student {

    String fullname;
    String email;
    Double marks;
    Boolean gender;
    String country;

    public Student() {
    }

    public Student(String fullname, String email, Double marks, Boolean gender, String country) {
        this.fullname = fullname;
        this.email = email;
        this.marks = marks;
        this.gender = gender;
        this.country = country;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonIgnore
    public Object[] getArray() {
        return new Object[]{
            getFullname(),
            getEmail(),
            getGender(),
            getMarks(),
            getCountry()
        };
    }
}
