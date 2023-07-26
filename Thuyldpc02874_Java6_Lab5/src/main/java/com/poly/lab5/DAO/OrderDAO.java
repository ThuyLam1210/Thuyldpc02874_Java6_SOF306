package com.poly.lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.Order;

public interface OrderDAO extends JpaRepository<Order,Long>{
    
}
