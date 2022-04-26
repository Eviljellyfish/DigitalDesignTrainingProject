package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.entity.UserAuthData;
import com.kashigin.stanislav.entity.secutity.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthDataService implements UserDetailsService {

    private final UserAuthDataRepository userAuthDataRepository;

    public UserAuthDataService(UserAuthDataRepository userAuthDataRepository) {
        this.userAuthDataRepository = userAuthDataRepository;
    }

    public UserAuthData add(UserAuthData userAuthData) {
        return userAuthDataRepository.save(userAuthData);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthData user = userAuthDataRepository.findByLogin(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found.");
        return new UserPrincipal(user);
    }
}
