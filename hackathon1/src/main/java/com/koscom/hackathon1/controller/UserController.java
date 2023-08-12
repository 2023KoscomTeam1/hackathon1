package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.Asset;
import com.koscom.hackathon1.domain.HoldingAsset;
import com.koscom.hackathon1.domain.IPOAsset;
import com.koscom.hackathon1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/{userId}/place")
    public String getUserPlace(@PathVariable String userId) {
        return userService.getUser(userId).getUserPlace().toString();
    }

    @GetMapping("/{userId}/assets")
    public List<HoldingAsset> getAssets(@PathVariable String userId) {
        return userService.getAssetsBy(userId);
    }

    @GetMapping("/{userId}/ipos")
    public List<IPOAsset> getIPOAssets(@PathVariable String userId) {
        return userService.getIPOsBy(userId);
    }
}
