package com.tcb.homedepot;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Email Notification Service");
    }
}
