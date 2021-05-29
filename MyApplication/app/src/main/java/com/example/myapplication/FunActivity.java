package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FunActivity extends AppCompatActivity {



    private final String [] data = {"下一页","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
            "Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
            "Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String> (
                FunActivity.this, android.R.layout.simple_list_item_1,data);
        ListView listView = findViewById(R.id.lv_1);
        listView.setAdapter(arrayAdapter);

        Button button = findViewById(R.id.submit_fun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunActivity.this,FunActivity1.class);
                startActivity(intent);
            }
        });
    }
}