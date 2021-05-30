package com.example.mainviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater().from(this);
        View view1 = inflater.inflate(R.layout.layout1, null);
        View view2 = inflater.inflate(R.layout.layout2, null);
        View view3 = inflater.inflate(R.layout.layout3, null);

        List<View> views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);

        ViewPager viewPager =  findViewById(R.id.vp);

        MyAdapter myAdapter = new MyAdapter(views);
        viewPager.setAdapter(myAdapter);

    }
}