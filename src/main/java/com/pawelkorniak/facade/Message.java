package com.pawelkorniak.facade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    ComnatUser author;
    String message;
    LocalDateTime time;

    public void setLocalDateTime() {
        this.time = LocalDateTime.now();
    }
}
