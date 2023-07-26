package com.poly.lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Category;

public interface CategoryDAO extends JpaRepository<Category,String>{
    
}
