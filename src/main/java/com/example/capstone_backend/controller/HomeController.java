// HomeController.java
package com.example.capstone_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "Spring Boot 서버가 정상 실행 중입니다!";
    }
}
