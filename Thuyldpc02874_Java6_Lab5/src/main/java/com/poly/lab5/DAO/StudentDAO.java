package com.poly.lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Student;

public interface StudentDAO extends JpaRepository<Student,String>{
    
}
