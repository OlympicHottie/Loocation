package com.olympichottie.loocation.messages;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MessageStore{
    public static final int MAX_NUMBER_OF_MESSAGES = 5;
    ArrayAdapter<String> adapter;
    ArrayList<String> messages;

    public MessageStore(ArrayAdapter<String> adapter, ArrayList<String> messages) {
        this.adapter = adapter;
        this.messages = messages;
    }

    public void addMessage(Message message) {
        if(messages.size()>= MAX_NUMBER_OF_MESSAGES){
            messages.remove(messages.size()-1);
        }
        messages.add(0,message.getMessageBody());
        adapter.notifyDataSetChanged();
    }


}
