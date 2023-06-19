package com.example.webcaycanh.Repository;

import com.example.webcaycanh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface IProductRepository extends JpaRepository<Product, Long>{
}
