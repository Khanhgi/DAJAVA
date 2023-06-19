package com.example.webcaycanh.Services;

import com.example.webcaycanh.Repository.IRoleRepository;
import com.example.webcaycanh.entity.Category;
import com.example.webcaycanh.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        } else {
            throw new RuntimeException("Role not found");
        }
    }
}
