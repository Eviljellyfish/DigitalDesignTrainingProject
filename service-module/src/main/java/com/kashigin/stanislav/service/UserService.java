package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.OrgStructureRepository;
import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.dao.repository.UserRepository;
import com.kashigin.stanislav.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OrgStructureRepository orgStructureRepository;

    private final UserAuthDataService userAuthDataService;

    public UserService(UserRepository userRepository, OrgStructureRepository orgStructureRepository, UserAuthDataService userAuthDataService) {
        this.userRepository = userRepository;
        this.orgStructureRepository = orgStructureRepository;
        this.userAuthDataService = userAuthDataService;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(long id) {
        List<OrgStructure> controlledOrgs = new ArrayList<>(orgStructureRepository.findAllByHeadId(id));
        for (OrgStructure org : controlledOrgs) {
            org.setHead(null);
        }
        UserAuthData userAuthData = userAuthDataService.findByUserId(id);
        if (userAuthData != null)
            userAuthDataService.delete(userAuthData.getId());
        userRepository.deleteById(id);
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        return addUser(user);
    }
}
