package com.olympichottie.loocation.messages;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.olympichottie.loocation.R;

import java.util.ArrayList;

/**
 * Custom adapter for message list view
 */

public class MessageListAdapter extends ArrayAdapter<Message> {
    public MessageListAdapter(@NonNull Context context, @NonNull ArrayList<Message> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Message message = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        convertView = inflateLayout(convertView,parent);

        populateView(convertView, message);

        return convertView;
    }

    private View inflateLayout(View convertView, ViewGroup parent) {
        if (convertView == null) {
             convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);
        }
        return convertView;
    }

    private void populateView(View convertView, Message message) {
        TextView messageText = (TextView) convertView.findViewById(R.id.messageText);
        TextView messageLocation = (TextView) convertView.findViewById(R.id.messageLocation);
        messageText.setText(message.getMessageContent());
        messageLocation.setText(message.getLocation().toString());
    }


}
