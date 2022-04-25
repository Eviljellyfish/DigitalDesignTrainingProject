package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.RoleRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
import com.kashigin.stanislav.entity.Role;
import com.kashigin.stanislav.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }
    public Role addRole(Role role) {
        roleRepository.save(role);
        return role;
    }

    public Optional<Role> find(long id) {
        return roleRepository.findById(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    public void delete(long id) {
        if (id > 2) {
            List<User> users = userRepository.findAllByRoleId(id);
            for (User user : users) {
                user.setRole(roleRepository.getById(1l));
            }
            roleRepository.deleteById(id);
        }
        else
            throw new IllegalArgumentException("Role deletion argument must me greater-than 2");
    }
}
