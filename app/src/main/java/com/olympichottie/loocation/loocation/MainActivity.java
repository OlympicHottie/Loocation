package com.olympichottie.loocation.loocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> messages = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.LocationsList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, messages);
        mListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Button sendMessageButton = (Button) findViewById(R.id.sendButton);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               addTextFromInputToList(v);
            }
        });
    }

    public void addTextFromInputToList(View view){
        TextView textView = (TextView) findViewById(R.id.editText);
        String textToAdd = textView.getText().toString();
        messages.add(textToAdd);
        adapter.notifyDataSetChanged();
    }


}
