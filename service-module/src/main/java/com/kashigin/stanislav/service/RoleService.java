package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.RoleRepository;
import com.kashigin.stanislav.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addRole(Role role) {
        roleRepository.save(role);
        return role;
    }

    public Optional<Role> find(String name) {
        return roleRepository.findById(name);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    public void delete(String name) {
        roleRepository.deleteById(name);
    }
}
