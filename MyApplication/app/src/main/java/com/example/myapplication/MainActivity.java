package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editUsername;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.submit);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,FunActivity.class);
//                startActivity(intent);
//            }
//        });

        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);

        button.setOnClickListener(this::onClick);
    }
    public void onClick(View view){
        String name = editUsername.getText().toString();
        String pass = editPassword.getText().toString();
        Intent intent = new Intent(MainActivity.this,FunActivity.class);
        startActivity(intent);
    }
}