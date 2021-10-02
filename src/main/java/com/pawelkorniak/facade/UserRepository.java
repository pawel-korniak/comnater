package com.pawelkorniak.facade;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserRepository {
    Set<ComnatUser> users = new HashSet<>();

    public void addUser(ComnatUser user){
        users.add(user);
    }

    public ComnatUser findUserByName(String name){
        return users.stream().filter(user -> name.equals(user.login)).findAny().get();
    }

    public void addAll(List<ComnatUser> comnatUsers) {
        users.addAll(comnatUsers);
    }
}
