package com.example.webcaycanh.Repository;

import com.example.webcaycanh.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
