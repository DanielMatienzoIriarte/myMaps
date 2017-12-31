package com.example.danmat.mymaps.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danmat.mymaps.MapsActivity;
import com.example.danmat.mymaps.R;
import com.example.danmat.mymaps.pojo.PlaceOfInterest;

import java.util.ArrayList;

public class PlaceOfInterestAdapter extends RecyclerView.Adapter<PlaceOfInterestAdapter.PlaceOfInterestViewHolder>{
    ArrayList<PlaceOfInterest> placeOfInterestList;
    private Activity mainActivity;

    public PlaceOfInterestAdapter(ArrayList<PlaceOfInterest> placeOfInterestList, Activity activity){
        this.placeOfInterestList = placeOfInterestList;
        this.mainActivity = activity;
    }

    @Override
    public PlaceOfInterestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_place_of_interest, parent, false);
        return new PlaceOfInterestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlaceOfInterestViewHolder placeOfInterestViewHolder, int position) {
        final PlaceOfInterest placeOfInterest = placeOfInterestList.get(position);
        placeOfInterestViewHolder.cardview_main_portrait.setImageResource(placeOfInterest.getAvatar());
        placeOfInterestViewHolder.cardview_main_name.setText(placeOfInterest.getName());
        placeOfInterestViewHolder.cardview_main_portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity, placeOfInterest.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        placeOfInterestViewHolder.cardview_main_portrait.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent petDetailIntent = new Intent(mainActivity, MapsActivity.class);
                petDetailIntent.putExtra("Portrait", placeOfInterest.getAvatar());
                petDetailIntent.putExtra("Name", placeOfInterest.getName());
                petDetailIntent.putExtra("Latitude", placeOfInterest.getLatitude());
                petDetailIntent.putExtra("Longitude", placeOfInterest.getLongitude());
                mainActivity.startActivity(petDetailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeOfInterestList.size();
    }

    public static class PlaceOfInterestViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardview_main_portrait;
        private TextView cardview_main_name;

        public PlaceOfInterestViewHolder(View itemView) {
            super(itemView);

            cardview_main_portrait = (ImageView) itemView.findViewById(R.id.cardview_main_imageview_portrait);
            cardview_main_name = (TextView) itemView.findViewById(R.id.cardview_main_textview_name);
        }
    }
}
