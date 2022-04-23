package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
import com.kashigin.stanislav.entity.*;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OrgStructureRepository orgStructureRepository;

    public UserService(UserRepository userRepository, OrgStructureRepository orgStructureRepository) {
        this.userRepository = userRepository;
        this.orgStructureRepository = orgStructureRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        return addUser(user);
    }

//    public List<User> findUsersByName(String name) {
//        throw new NotImplementedException();
//    }
//
//    public List<User> findUsersByFirstNameAndSecondName(String firstName, String secondName) {
//        throw new NotImplementedException();
//    }
//
//    public boolean moveUserToOrg(int id, OrgStructure org) {
//        throw new NotImplementedException();
//    }
//
//    public boolean changeUserRole(int id, UserRoleEnum role) {
//        throw new NotImplementedException();
//    }
//
//    public boolean changeUserPosition(int id, String pos) {
//        throw new NotImplementedException();
//    }
//
//    public boolean changeUserFirstName(int id, String name) {
//        throw new NotImplementedException();
//    }
//
//    public boolean changeUserSecondName(int id, String name) {
//        throw new NotImplementedException();
//    }

}
