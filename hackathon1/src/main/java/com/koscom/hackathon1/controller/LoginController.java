package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
