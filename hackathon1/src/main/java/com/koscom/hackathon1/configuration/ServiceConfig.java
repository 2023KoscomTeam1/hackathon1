package com.koscom.hackathon1.configuration;

import com.koscom.hackathon1.repository.UserRepository;
import com.koscom.hackathon1.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
