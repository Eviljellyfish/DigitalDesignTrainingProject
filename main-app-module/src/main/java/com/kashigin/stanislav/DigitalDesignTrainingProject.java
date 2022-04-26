package com.kashigin.stanislav;

import com.kashigin.stanislav.entity.UserAuthData;
import com.kashigin.stanislav.service.RoleService;
import com.kashigin.stanislav.service.UserAuthDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ResourceBundle;

@SpringBootApplication
@EnableWebSecurity
public class DigitalDesignTrainingProject {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("init");
        ApplicationContext context = SpringApplication.run(DigitalDesignTrainingProject.class, args);
        UserAuthDataService userAuthDataService = context.getBean(UserAuthDataService.class);
        userAuthDataService.add(new UserAuthData(resourceBundle.getString("admin.login"),
                                    context.getBean(PasswordEncoder.class).encode(resourceBundle.getString("admin.password")),
                                    context.getBean(RoleService.class).findByName("ADMIN").get()));
        userAuthDataService.add(new UserAuthData(resourceBundle.getString("user.login"),
                context.getBean(PasswordEncoder.class).encode(resourceBundle.getString("user.password")),
                context.getBean(RoleService.class).findByName("USER").get()));

    }
}
