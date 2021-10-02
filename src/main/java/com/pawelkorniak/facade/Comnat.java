package com.pawelkorniak.facade;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Comnat {
    String name;
    List<Message> messages;


    public Comnat(String name) {
        this.name = name;
        messages = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comnat comnat = (Comnat) o;
        return name.equals(comnat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void add(Message message) {
        messages.add(message);
    }
}
