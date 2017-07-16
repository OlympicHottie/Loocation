package com.olympichottie.loocation.activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.olympichottie.loocation.R;
import com.olympichottie.loocation.location.LocationPermissionManager;
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
        ArrayList<String> messages = new ArrayList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,messages);
        listView.setAdapter(adapter);
        return new MessageStore(adapter,messages);
    }


    private void initLocationGetter(Activity thisActivity) {
        LocationPermissionManager locationPermissionManager = new LocationPermissionManager();
        locationPermissionManager.requestPermission(this);
        //FusedLocationProviderClient locationProviderClient = LocationServices.getFusedLocationProviderClient(thisActivity);
    }
}
