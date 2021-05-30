package com.example.myapplication.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {

    private List<Bean> data;
    private Context context;

    public MyAdapter1(List<Bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_item,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MyAdapter1.MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onRecyclerItemClick != null){
                        onRecyclerItemClick.OnRecyclerItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    private OnRecyclerItemClick onRecyclerItemClick;

    public void setOnRecyclerItemClick(OnRecyclerItemClick listener){
        onRecyclerItemClick = listener;
    }

    public interface OnRecyclerItemClick{
        void OnRecyclerItemClick(int position);
    }
}
