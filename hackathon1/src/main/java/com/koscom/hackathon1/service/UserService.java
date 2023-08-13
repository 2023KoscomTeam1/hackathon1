package com.koscom.hackathon1.service;

import com.koscom.hackathon1.domain.HoldingAsset;
import com.koscom.hackathon1.domain.HoldingIPO;
import com.koscom.hackathon1.domain.UserInfo;
import com.koscom.hackathon1.exception.InsufficientBalanceException;
import com.koscom.hackathon1.repository.IPOAssetRepository;
import com.koscom.hackathon1.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserRepository userRepository;
    private final IPOAssetRepository ipoAssetRepository;

    public UserService(UserRepository userRepository, IPOAssetRepository ipoAssetRepository) {
        this.userRepository = userRepository;
        this.ipoAssetRepository = ipoAssetRepository;
    }

    public UserInfo getUser(String userId) {
        return userRepository.findBy(userId);
    }

    public List<HoldingAsset> getAssetsBy(String userId) {
        return userRepository.findBy(userId).getUserAssets();
    }

    public List<HoldingIPO> getHoldingIPOsBy(String userId) {
        return userRepository.findBy(userId).getUserIPOs();
    }

    public void addBalance(String userId, Long amount) {
        UserInfo userInfo = userRepository.findBy(userId);
        Long preBalance = userInfo.getBalance();

        userInfo.setBalance(preBalance + amount);

        userRepository.save(userInfo);
    }

    public void minusBalance(String userId, Long amount) {
        UserInfo userInfo = userRepository.findBy(userId);
        Long preBalance = userInfo.getBalance();

        if (preBalance < amount) {
            throw new InsufficientBalanceException("Insufficient balance. " + "userId: " + userId + " Current: " + preBalance);
        }

        userInfo.setBalance(preBalance - amount);

        userRepository.save(userInfo);
    }
}
