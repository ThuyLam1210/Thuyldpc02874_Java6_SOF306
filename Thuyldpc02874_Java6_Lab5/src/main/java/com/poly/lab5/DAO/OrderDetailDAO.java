package com.poly.lab5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab5.entity.OrderDetail;
public interface OrderDetailDAO extends JpaRepository<OrderDetail,Long>{
    
}
