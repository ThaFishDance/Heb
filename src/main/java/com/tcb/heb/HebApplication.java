package com.tcb.heb;

import com.tcb.heb.entities.Address;
import com.tcb.heb.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HebApplication {

    public static void main(String[] args) {
//        var context = SpringApplication.run(HebApplication.class, args);
        var user = User
            .builder()
            .name("John")
            .password("password")
            .email("test@test.com")
            .build();

        var address = Address
            .builder()
            .street("Street")
            .city("City")
            .state("State")
            .zip("Zip")
            .build();

        user.addAddress(address);
        System.out.println(user);


    }

}
