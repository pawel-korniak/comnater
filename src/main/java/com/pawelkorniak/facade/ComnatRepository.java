package com.pawelkorniak.facade;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComnatRepository {
    List<Comnat> comnats;

    public ComnatRepository() {
        comnats = new ArrayList<>();
        comnats.addAll(List.of(
                new Comnat("Comnat"),
                new Comnat("Sport")
        ));
    }

    public Comnat findByName(String name) {
        return comnats.stream().filter(comnat -> name.equals(comnat.name)).findFirst().get();
    }
}
