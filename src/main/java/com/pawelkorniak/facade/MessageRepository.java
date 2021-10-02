package com.pawelkorniak.facade;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository {

    List<Message> messages = new ArrayList<>();


    public MessageRepository() {
        messages.addAll(List.of(
                new Message("author1", "some message1 from author 1"),
                new Message("author2", "some message from author 2"),
                new Message("author3", "some message from author 3"),
                new Message("author1", "some message2 from author 1"),
                new Message("author2", "some message2 from author 2"),
                new Message("author1", "some message3 from author 1")));

    }

    public void add(Message message) {
        messages.add(message);
    }
}
