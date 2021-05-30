package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.list.Bean;
import com.example.myapplication.list.MyAdapter1;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity2 extends AppCompatActivity {

    private List<Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);

        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("zph"+i);
            data.add(bean);
        }

        RecyclerView recyclerView = findViewById(R.id.rv);

//        水平布局
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);

//        网格布局
//        GridLayoutManager manager = new GridLayoutManager(this,3);
//        recyclerView.setLayoutManager(manager);

//        瀑布流
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);

        MyAdapter1 adapter1 = new MyAdapter1(data,this);

        recyclerView.setAdapter(adapter1);
        adapter1.setOnRecyclerItemClick(new MyAdapter1.OnRecyclerItemClick() {
            @Override
            public void OnRecyclerItemClick(int position) {
                Log.e("shy","点击了"+position);
            }
        });
    }
}