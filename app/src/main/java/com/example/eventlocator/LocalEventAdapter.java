package com.example.eventlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LocalEventAdapter extends RecyclerView.Adapter<LocalEventAdapter.EventViewHolder>{

    private String [] eventName;
    private int [] eventPicture;
    private Context context;

    public LocalEventAdapter(Context context, String [] eventName, int [] eventPicture)
    {
        this.context = context;
        this.eventName = eventName;
        this.eventPicture = eventPicture;

    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.localevent_design,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {


        holder.eventImg.setImageResource(eventPicture[position]);
        holder.eventName.setText(eventName[position]);

    }

    @Override
    public int getItemCount() {
        return eventName.length;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        ImageView eventImg;
        TextView eventName;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            eventImg = itemView.findViewById(R.id.eventPicture);
            eventName = itemView.findViewById(R.id.eventName);
        }
    }
}
