package com.pawelkorniak.facade;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    List<ComnatUser> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.addAll(List.of(
                new ComnatUser("pawel"),
                new ComnatUser("doris"),
                new ComnatUser("aaa")
        ));
    }

    public void addUser(ComnatUser user){
        users.add(user);
    }

    public ComnatUser findUserByName(String name){
        return users.stream().filter(user -> name.equals(user.login)).findAny().get();
    }
}
