package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.list.Bean;
import com.example.myapplication.list.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity2 extends AppCompatActivity {

    private List<Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("shy"+i);
            data.add(bean);
        }

        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(new MyAdapter(data,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1){
                    Intent intent = new Intent(ListViewActivity2.this,RecyclerActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}