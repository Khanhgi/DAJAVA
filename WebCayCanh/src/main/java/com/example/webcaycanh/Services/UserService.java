package com.example.webcaycanh.Services;

import com.example.webcaycanh.entity.User;
import com.example.webcaycanh.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public long countAdminUsers() {
        return userRepository.countAdminUsers();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}