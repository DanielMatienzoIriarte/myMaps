package com.example.danmat.mymaps.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.danmat.mymaps.R;
import com.example.danmat.mymaps.adapter.PlaceOfInterestAdapter;
import com.example.danmat.mymaps.pojo.PlaceOfInterest;
import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<PlaceOfInterest> placeOfInterestList;
    private RecyclerView placeOfInterestListRecyclerView;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        placeOfInterestListRecyclerView = (RecyclerView) v.findViewById(R.id.main_recyclerView_placeOfInterest);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        placeOfInterestListRecyclerView.setLayoutManager(llm);
        initializeplaceOfInterestList();
        initializeAdapter();

        return v;
    }

    private void initializeplaceOfInterestList(){
        placeOfInterestList = new ArrayList<PlaceOfInterest>();
        placeOfInterestList.add(new PlaceOfInterest(R.drawable.concordia, "Cristo de la Concordia", -17.384386, -66.135002));
        placeOfInterestList.add(new PlaceOfInterest(R.drawable.stadium, "Stadium Felix Capriles", -17.379574, -66.161780));
        placeOfInterestList.add(new PlaceOfInterest(R.drawable.mainsquare, "Plaza 14 de Septiembre", -17.393725, -66.156733));
        placeOfInterestList.add(new PlaceOfInterest(R.drawable.chola, "Sombrero de Chola", -17.373263, -66.149627));
    }

    private void initializeAdapter(){
        PlaceOfInterestAdapter PlaceOfInterestAdapter = new PlaceOfInterestAdapter(placeOfInterestList, getActivity());
        placeOfInterestListRecyclerView.setAdapter(PlaceOfInterestAdapter);
    }
}
