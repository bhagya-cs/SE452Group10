package com.group10.se452_g10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Se452Group10Application {

    public static void main(String[] args) {
        SpringApplication.run(Se452Group10Application.class, args);
    }

    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot!--  Hey DS 22";
    }
}
