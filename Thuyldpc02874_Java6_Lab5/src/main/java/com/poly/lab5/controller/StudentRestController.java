package com.poly.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poly.lab5.DAO.StudentDAO;
import com.poly.lab5.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@RestController
public class StudentRestController {
    @Autowired
    StudentDAO dao;

    @GetMapping("/rest/students")
    public List<Student> getAll(Model model) {
        return dao.findAll();
    }

    @GetMapping("/rest/students/{email}")
    public Student getOne(@PathVariable("email") String email) {

        return dao.findById(email).get();
    }

    @PostMapping("/rest/students")
    public Student post(@RequestBody Student student) {
        dao.save(student);
        return student;
    }

    @PutMapping("/rest/students/{email}")
    public Student put(@PathVariable("email") String email, @RequestBody Student student) {
        dao.save(student);
        return student;
    }

    @DeleteMapping("/rest/students/{email}")
    public void delete(@PathVariable("email") String email) {
        dao.deleteById(email);
      
    }

}
