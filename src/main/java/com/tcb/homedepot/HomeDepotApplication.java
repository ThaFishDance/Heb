package com.tcb.homedepot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeDepotApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(HomeDepotApplication.class, args);
        var manager = context.getBean(NotificationManager.class);
        manager.sendNotification("Hello World");
    }

}
