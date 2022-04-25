package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.RoleRepository;
import com.kashigin.stanislav.entity.Role;
import org.springframework.stereotype.Service;

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

    public Role find(String name) {
        return roleRepository.findById(name).get();
    }

    public void delete(String name) {
        roleRepository.deleteById(name);
    }
}
