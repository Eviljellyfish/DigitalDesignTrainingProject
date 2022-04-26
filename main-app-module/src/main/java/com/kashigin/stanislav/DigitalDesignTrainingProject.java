package com.kashigin.stanislav;

import com.kashigin.stanislav.config.SecurityConfig;
import com.kashigin.stanislav.entity.UserAuthData;
import com.kashigin.stanislav.service.UserAuthDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Security;

@SpringBootApplication
public class DigitalDesignTrainingProject {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DigitalDesignTrainingProject.class, args);
        UserAuthDataService userAuthDataService = context.getBean(UserAuthDataService.class);
        userAuthDataService.add(new UserAuthData("admin", context.getBean(PasswordEncoder.class).encode("admin")));
    }
}
