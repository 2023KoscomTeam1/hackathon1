package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.request.BalanceAddRequest;
import com.koscom.hackathon1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    private final UserService userService;

    BalanceController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody BalanceAddRequest request) {
        userService.addBalance(request.getUserId(), request.getAmount());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/minus")
    public ResponseEntity<Object> minus(@RequestBody BalanceAddRequest request) {
        userService.minusBalance(request.getUserId(), request.getAmount());

        return ResponseEntity.ok().build();
    }
}
