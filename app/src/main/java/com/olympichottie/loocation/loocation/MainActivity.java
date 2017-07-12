package com.olympichottie.loocation.loocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.LocationsList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        Button mClickButton1 = (Button) findViewById(R.id.sendButton);
        mClickButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               addTextFromInputToList(v);
            }
        });
    }

    public void addTextFromInputToList(View v){
        TextView textView = (TextView) findViewById(R.id.editText);
        String textToAdd = textView.getText().toString();
        listItems.add(textToAdd);
        adapter.notifyDataSetChanged();
    }


}
