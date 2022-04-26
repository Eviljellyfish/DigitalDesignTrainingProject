package com.kashigin.stanislav.service;

import com.kashigin.stanislav.dao.repository.UserAuthDataRepository;
import com.kashigin.stanislav.entity.UserAuthData;
import com.kashigin.stanislav.entity.secutity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserAuthDataRepository userAuthDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthData user = userAuthDataRepository.findByLogin(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found.");
        return new UserPrincipal(user);
    }
}
