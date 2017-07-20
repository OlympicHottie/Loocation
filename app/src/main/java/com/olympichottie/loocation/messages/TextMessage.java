package com.olympichottie.loocation.messages;

import com.olympichottie.loocation.location.SimpleLocation;

public class TextMessage implements Message {
    private String messageBody;
    private SimpleLocation location;

    public TextMessage(String messageBody, SimpleLocation location) {
        this.messageBody = messageBody;
        this.location = location;
    }

    @Override
    public String getMessageContent() {
        return messageBody;
    }

    @Override
    public SimpleLocation getLocation() {
        return location;
    }
}
