package com.olympichottie.loocation.messages;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.olympichottie.loocation.R;

import java.util.ArrayList;

/**
 * Created by mminkin on 7/12/17.
 */

public class MessageStore {
    ArrayList<String> messages = new ArrayList();
    ArrayAdapter<String> adapter;

    public MessageStore(Activity activity, ListView listView) {
        adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, messages);
        listView.setAdapter(adapter);
    }

    public void addMessage(Message message) {
        messages.add(message.getMessageBody());
        adapter.notifyDataSetChanged();
    }
}
