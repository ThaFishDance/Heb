package com.tcb.heb;

import com.tcb.heb.entities.Address;
import com.tcb.heb.entities.User;
import com.tcb.heb.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HebApplication.class, args);
    }

}
