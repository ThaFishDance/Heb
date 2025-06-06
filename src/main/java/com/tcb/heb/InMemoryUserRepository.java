package com.tcb.heb;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<String, User>();


    @Override
    public void save(User user) {
        System.out.println("Saving user: " + user);
        this.users.put(user.getName(), user);
    }
}
