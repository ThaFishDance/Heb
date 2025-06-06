package com.tcb.heb;

public class UserService {

    UserRepository userRepository;
    NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void sendRegistrationConfirmation(String message, User user) {
        this.notificationService.send(message, user.getEmail());
    }


    public void registerUser(User user) {
        System.out.println("Registering user: " + user);
        userRepository.save(user);
        System.out.println("User registered: " + user);
        sendRegistrationConfirmation("You have been registered", user);
    }
}
