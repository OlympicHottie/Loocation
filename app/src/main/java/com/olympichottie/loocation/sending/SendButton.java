package com.olympichottie.loocation.sending;

import android.widget.Button;
import android.widget.TextView;

import com.olympichottie.loocation.messages.Message;
import com.olympichottie.loocation.messages.MessageStore;
import com.olympichottie.loocation.messages.TextMessage;

public class SendButton {
    private Button buttonView;

    public SendButton(Button buttonView) {
        this.buttonView = buttonView;
    }

    public void setOnClickListener(TextView input, MessageStore messageStore) {
        buttonView.setOnClickListener(view -> {
            Message message = new TextMessage(input.getText().toString());
            messageStore.addMessage(message);
        });
    }

}
