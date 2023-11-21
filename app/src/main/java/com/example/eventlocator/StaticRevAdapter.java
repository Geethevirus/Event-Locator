package com.example.eventlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRevAdapter extends RecyclerView.Adapter<StaticRevAdapter.StaticViewHolder> {

    private ArrayList<EventCategoryModel> items;
    private Context context;

    public StaticRevAdapter(Context context, ArrayList<EventCategoryModel> eventCategoryModels)
    {
        this.items = eventCategoryModels;
        this.context = context;

    }

    @NonNull
    @Override
    public StaticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(context).inflate(R.layout.event_item,parent,false);

        return new StaticViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaticViewHolder holder, int position) {

        holder.eventName.setText(items.get(position).getCategoryName());
        holder.img.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class StaticViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView eventName;

        public StaticViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.categoryImg);
            eventName = itemView.findViewById(R.id.cateName);
        }
    }
}
