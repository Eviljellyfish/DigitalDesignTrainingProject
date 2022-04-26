package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.entity.UserAuthData;
import org.springframework.stereotype.Service;

@Service
public class UserAuthDataService {

    private final UserAuthDataRepository userAuthDataRepository;

    public UserAuthDataService(UserAuthDataRepository userAuthDataRepository) {
        this.userAuthDataRepository = userAuthDataRepository;
    }

    public UserAuthData add(UserAuthData userAuthData) {
        return userAuthDataRepository.save(userAuthData);
    }
}
