package com.example.webcaycanh.Repository;

import com.example.webcaycanh.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends  JpaRepository<Category, Long>{
}
