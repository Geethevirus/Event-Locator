package com.example.eventlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingEventAdapter extends RecyclerView.Adapter<UpcomingEventAdapter.UpcomingViewHolder> {

    private String [] eventName;
    private String [] eventDesc;
    private int [] eventPicture;
    private Context context;

    public UpcomingEventAdapter(Context context, String [] eventName, String [] eventDesc,int [] eventPicture )
    {

        this.context = context;
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventPicture = eventPicture;


    }
    @NonNull
    @Override
    public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.upcoming_events,parent,false);

        return new UpcomingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position) {


        holder.ePicture.setImageResource(eventPicture[position]);
        holder.eName.setText(eventName[position]);
        holder.eDesc.setText(eventDesc[position]);

    }

    @Override
    public int getItemCount() {
        return eventDesc.length;
    }

    public class UpcomingViewHolder extends RecyclerView.ViewHolder {

        ImageView ePicture;
        TextView eName;
        TextView eDesc;
        public UpcomingViewHolder(@NonNull View itemView) {
            super(itemView);

            ePicture = itemView.findViewById(R.id.shapeableImageView);
            eName = itemView.findViewById(R.id.eventNameUpcoming);
            eDesc = itemView.findViewById(R.id.eventdesc);


        }
    }
}
