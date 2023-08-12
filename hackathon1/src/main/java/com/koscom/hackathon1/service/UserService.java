package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.UserInfo;
import com.koscom.hackathon1.exception.InsufficientBalanceException;
import com.koscom.hackathon1.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfo getUser(String userId) {
        return userRepository.findBy(userId);
    }

    public void addBalance(String userId, int amount) {
        UserInfo userInfo = userRepository.findBy(userId);
        int preBalance = userInfo.getBalance();

        userInfo.setBalance(preBalance + amount);

        userRepository.save(userInfo);
    }

    public void minusBalance(String userId, int amount) {
        UserInfo userInfo = userRepository.findBy(userId);
        int preBalance = userInfo.getBalance();

        if (preBalance < amount) {
            throw new InsufficientBalanceException("Insufficient balance. " + "userId: " + userId + " Current: " + preBalance);
        }

        userInfo.setBalance(preBalance - amount);
        
        userRepository.save(userInfo);
    }
}
