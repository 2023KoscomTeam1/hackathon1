package com.koscom.hackathon1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/success")
    public ResponseEntity<Object> success() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fail")
    public ResponseEntity<Object> fail() {
        return ResponseEntity.badRequest().build();
    }
}
