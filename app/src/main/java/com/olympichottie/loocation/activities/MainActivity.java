package com.olympichottie.loocation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.olympichottie.loocation.R;
import com.olympichottie.loocation.messages.MessageStore;
import com.olympichottie.loocation.sending.SendButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageStore messageStore = initMessageStore();
        initSendButton(messageStore);
    }

    private void initSendButton(MessageStore messageStore) {
        Button sendMessageButton = (Button) findViewById(R.id.sendButton);
        SendButton sendButton = new SendButton(sendMessageButton);

        TextView textView = (TextView) findViewById(R.id.editText);
        sendButton.setOnClickListener(textView, messageStore);
    }

    private MessageStore initMessageStore() {
        ListView listView = (ListView) findViewById(R.id.LocationsList);
        return new MessageStore(this, listView);
    }

}
