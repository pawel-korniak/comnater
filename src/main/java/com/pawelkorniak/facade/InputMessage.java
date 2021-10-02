package com.pawelkorniak.facade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InputMessage extends Message{
    String comnatName;

    public InputMessage(String author, String message, String comnatName) {
        super(author, message);
        this.comnatName = comnatName;
    }
}
