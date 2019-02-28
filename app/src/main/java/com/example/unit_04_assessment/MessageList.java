package com.example.unit_04_assessment;

import java.util.List;

public class MessageList {
    private List<Message> message;

    public MessageList(List<Message> message) {
        this.message = message;
    }

    public List<Message> getMessage() {
        return message;
    }
}
