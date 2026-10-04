package com.springBoot_With_AWS_CICd.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class Controller {
    @GetMapping
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Welcome to Spring Boot Application ");
    }
}
