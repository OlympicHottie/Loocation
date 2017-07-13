package com.olympichottie.loocation.messages;

public class TextMessage implements Message {
    private String messageBody;

    public TextMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String getMessageBody() {
        return messageBody;
    }
}
