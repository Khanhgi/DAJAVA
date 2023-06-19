package com.example.webcaycanh.Repository;

import com.example.webcaycanh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface IUserRepository extends JpaRepository<User, Long>{
    @Query("SELECT  COUNT(u) FROM User u WHERE u.role.id = 1 ")
    long countAdminUsers();

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

}

