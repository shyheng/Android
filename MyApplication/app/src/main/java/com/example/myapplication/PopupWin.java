package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupWin extends AppCompatActivity {

    private static final String SHY = "SHY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        Button button = findViewById(R.id.submit_pop);
        button.setOnClickListener(this::OnClick);
    }

    public void OnClick(View view){
        View popup = getLayoutInflater().inflate(R.layout.popup, null);

        PopupWindow popupWindow = new PopupWindow(popup, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.showAsDropDown(view);
        Button button = popup.findViewById(R.id.submit_pop_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupWin.this,ListViewActivity2.class);
                startActivity(intent);
                popupWindow.dismiss();
            }
        });

    }
}