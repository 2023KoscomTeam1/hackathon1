package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.response.UserResponse;
import com.koscom.hackathon1.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return UserResponse.from(userService.getUser(userId));
    }

    @GetMapping("/{userId}/place")
    public UserResponse getUserPlace(@PathVariable String userId) {
        UserResponse userResponse = new UserResponse();
        userResponse.setPlaceType(userService.getUser(userId).getUserPlace());

        return userResponse;
    }

    @GetMapping("/{userId}/assets")
    public UserResponse getAssets(@PathVariable String userId) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserAssets(userService.getAssetsBy(userId));

        return userResponse;
    }

    @GetMapping("/{userId}/balance")
    public UserResponse getBalance(@PathVariable String userId) {
        UserResponse userResponse = new UserResponse();
        userResponse.setBalance(userService.getUser(userId).getBalance());

        return userResponse;
    }

    @GetMapping("/{userId}/ipos")
    public UserResponse getHoldingIPOs(@PathVariable String userId) {
        UserResponse userResponse = new UserResponse();
        System.out.println(userService.getHoldingIPOsBy(userId));
        System.out.println(userService.getUser(userId));
        userResponse.setHoldingIPOs(userService.getHoldingIPOsBy(userId));

        return userResponse;
    }
}
