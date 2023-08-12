package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.UserInfo;
import com.koscom.hackathon1.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfo getUser(String userId) {
        return userRepository.findBy(userId);
    }
}
