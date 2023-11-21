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
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private String [] placeName;
    private int [] eventPicture;
    private Context context;
    private List<ItemPlace> itemPlaces;

    public PlaceAdapter(Context context, List<ItemPlace> itemPlaceList )
    {
        this.context = context;
        itemPlaces = itemPlaceList;

    }
    public void setFilteredList(List<ItemPlace> itemPlaceList)
    {
        itemPlaces = itemPlaceList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.places_row,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        holder.place.setImageResource(itemPlaces.get(position).getePicture());
        holder.textView.setText(itemPlaces.get(position).geteName());

    }

    @Override
    public int getItemCount() {
        return itemPlaces.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView place;
        TextView textView;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            place = itemView.findViewById(R.id.placePicture);
            textView = itemView.findViewById(R.id.placeName);


        }
    }
}
