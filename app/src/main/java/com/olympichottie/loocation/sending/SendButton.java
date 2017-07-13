package com.olympichottie.loocation.sending;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.olympichottie.loocation.messages.Message;
import com.olympichottie.loocation.messages.MessageStore;
import com.olympichottie.loocation.messages.TextMessage;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by mminkin on 7/12/17.
 */

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
