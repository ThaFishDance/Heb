package com.tcb.heb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HebApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(HebApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L, "mosh@codewithmosh.com", "12345", "Mosh"));
        userService.registerUser(new User(1L, "mosh@codewithmosh.com", "12345", "Mosh"));

    }

}
