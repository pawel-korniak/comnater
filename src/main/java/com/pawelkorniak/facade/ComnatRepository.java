package com.pawelkorniak.facade;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ComnatRepository {
    Set<Comnat> comnats = new HashSet<>();

    public Comnat findByName(String name) {
        return comnats.stream().filter(comnat -> name.equals(comnat.name)).findFirst().get();
    }

    public Comnat add(Comnat comnat) {
        comnats.add(comnat);
        return comnat;
    }
}
