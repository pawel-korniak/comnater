package com.pawelkorniak.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final UserRepository userRepository;
    private final ComnatRepository comnatRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        userRepository.addAll(List.of(
                new ComnatUser("pawel")
                        .subscribeToComnat(comnatRepository.add(new Comnat("Sport")))
                        .subscribeToComnat(comnatRepository.add(new Comnat("Polityka"))),
                new ComnatUser("doris").subscribeToComnat(comnatRepository.add(new Comnat("Sport"))),
                new ComnatUser("aaa").subscribeToComnat(comnatRepository.add(new Comnat("Polityka")))
        ));

    }
}
