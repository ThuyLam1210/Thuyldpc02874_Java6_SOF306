package com.poly.lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Product;

public interface ProductDAO extends JpaRepository<Product,Integer>{
    
}
