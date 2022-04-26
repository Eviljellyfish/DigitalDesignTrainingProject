package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.RoleRepository;
import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
import com.kashigin.stanislav.entity.Role;
import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.entity.UserAuthData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserAuthDataRepository userAuthDataRepository;

    public RoleService(RoleRepository roleRepository, UserAuthDataRepository userAuthDataRepository) {
        this.roleRepository = roleRepository;
        this.userAuthDataRepository = userAuthDataRepository;
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
            List<UserAuthData> users = userAuthDataRepository.findAllByRoleId(id);
            for (UserAuthData user : users) {
                user.setRole(roleRepository.getById(1l));
            }
            roleRepository.deleteById(id);
        }
        else
            throw new IllegalArgumentException("Role deletion argument must me greater-than 2");
    }
}
