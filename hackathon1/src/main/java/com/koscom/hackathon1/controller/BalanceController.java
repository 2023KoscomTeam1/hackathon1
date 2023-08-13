package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.request.BalanceAddRequest;
import com.koscom.hackathon1.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    private final UserService userService;

    BalanceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Long> getBalance(@PathVariable String userId) {
        Long balance = userService.getUser(userId).getBalance();

        return ResponseEntity.ok(balance);
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
