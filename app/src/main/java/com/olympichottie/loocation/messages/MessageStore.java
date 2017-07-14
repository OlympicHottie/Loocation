package com.olympichottie.loocation.messages;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MessageStore {
    public static final int MAX_NUMBER_OF_MESSAGES = 5;
    ArrayList<String> messages = new ArrayList();
    ArrayAdapter<String> adapter;

    public MessageStore(Activity activity, ListView listView) {
        adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1,messages);
        listView.setAdapter(adapter);
    }

    public void addMessage(Message message) {
        if(messages.size()>= MAX_NUMBER_OF_MESSAGES){
            messages.remove(messages.size()-1);
        }
        messages.add(0,message.getMessageBody());
        adapter.notifyDataSetChanged();
    }


}
