package com.pawelkorniak.facade;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Comnat {
    String name;
    List<Message> messages;


    public Comnat(String name) {
        this.name = name;
        messages = new ArrayList<>();
    }

    public void add(Message message) {
        messages.add(message);
    }
}
