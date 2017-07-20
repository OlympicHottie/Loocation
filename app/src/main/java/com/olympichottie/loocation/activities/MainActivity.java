package com.olympichottie.loocation.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.olympichottie.loocation.R;
import com.olympichottie.loocation.location.LocationPermissionManager;
import com.olympichottie.loocation.messages.Message;
import com.olympichottie.loocation.messages.MessageListAdapter;
import com.olympichottie.loocation.messages.MessageStore;
import com.olympichottie.loocation.sending.SendButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SendButton sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLocationGetter(this);

        MessageStore messageStore = initMessageStore();
        initSendButton(messageStore);
    }

    private void initSendButton(MessageStore messageStore) {
        Button sendMessageButton = (Button) findViewById(R.id.sendButton);
        sendButton = new SendButton(this, sendMessageButton);

        TextView textView = (TextView) findViewById(R.id.editText);
        sendButton.setOnClickListener(textView, messageStore);
    }

    private MessageStore initMessageStore() {
        ListView listView = (ListView) findViewById(R.id.LocationsList);
        ArrayList<Message> messages = new ArrayList();
        ArrayAdapter<Message> adapter = new MessageListAdapter(this, messages);
        listView.setAdapter(adapter);
        return new MessageStore(adapter,messages);
    }


    private void initLocationGetter(Activity thisActivity) {
        LocationPermissionManager locationPermissionManager = new LocationPermissionManager();
        locationPermissionManager.requestPermission(this);
        //FusedLocationProviderClient locationProviderClient = LocationServices.getFusedLocationProviderClient(thisActivity);
    }
}
