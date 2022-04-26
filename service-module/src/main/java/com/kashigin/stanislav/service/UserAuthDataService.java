package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.entity.UserAuthData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthDataService {

    private final PasswordEncoder passwordEncoder;

    private final UserAuthDataRepository userAuthDataRepository;

    public UserAuthDataService(PasswordEncoder passwordEncoder, UserAuthDataRepository userAuthDataRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userAuthDataRepository = userAuthDataRepository;
    }

    public UserAuthData add(UserAuthData userAuthData) {
        UserAuthData userAuthData1 = new UserAuthData(userAuthData.getLogin(), passwordEncoder.encode(userAuthData.getHash()), userAuthData.getRole());
        userAuthDataRepository.save(userAuthData1);
        return userAuthData1;
    }

    public UserAuthData update(UserAuthData userAuthData) {
        return add(userAuthData);
    }

    public UserAuthData findByUser(User user) {
        return userAuthDataRepository.findByUser(user);
    }

    public UserAuthData findByUserId(long id) {
        return userAuthDataRepository.findByUser(id);
    }

    public void delete(long id) {
        if (id > 2)
            userAuthDataRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Can't delete system data");
    }


}
