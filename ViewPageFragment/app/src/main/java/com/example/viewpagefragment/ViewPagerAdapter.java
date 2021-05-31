package com.example.viewpagefragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    private List<String> titles = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();

    public ViewPagerAdapter(){
        titles.add("hell");
        titles.add("hell1");
        titles.add("hell3");
        titles.add("hell4");
        titles.add("hell5");
        titles.add("hell6");
        titles.add("hell7");
        titles.add("hell8");
        titles.add("hell9");
        titles.add("hell2");

//        colors.add(R.color.white);
//        colors.add(R.color.black);
//        colors.add(R.color.purple_200);
//        colors.add(R.color.material_on_surface_stroke);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewPagerViewHolder holder, int position) {
        holder.textView.setText(titles.get(position));
//        holder.relativeLayout.setBackgroundResource(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class  ViewPagerViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        RelativeLayout relativeLayout;
        public ViewPagerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.cont);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
