package com.example.eventlocator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private PlaceAdapter placeAdapter;
    private ArrayList<ItemPlace> items;
    private TextView noresultsfound;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.placerv);
        noresultsfound = view.findViewById(R.id.noresultsfound);

        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();

        items = new ArrayList<>();

        items.add(new ItemPlace("THE WEEKEND",R.drawable.theweekendlogo));
        items.add(new ItemPlace("SIN 1632",R.drawable.sinevent));
        items.add(new ItemPlace("SHORT LEFT",R.drawable.shortleft));
        items.add(new ItemPlace("CAFE 1632",R.drawable.cafe1632));
        items.add(new ItemPlace("GARANKUWA SHISANYAMA",R.drawable.garankuwa));
        items.add(new ItemPlace("AYOBA SHISANYAMA",R.drawable.ayoba));
        items.add(new ItemPlace("PHELI SHISANYAMA",R.drawable.pheli));
        items.add(new ItemPlace("EUROPA",R.drawable.europa));
        items.add(new ItemPlace("MAKOYA SHANDIS",R.drawable.makoya_shandis));
        items.add(new ItemPlace("BUSY CORNER",R.drawable.busycorner));
        items.add(new ItemPlace("SLOTJHILE PUB & SHISANYAMA",R.drawable.slotjhile));

        placeAdapter = new PlaceAdapter(getContext(), items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(placeAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }


        });


    }

    private void filterList(String s) {

        List<ItemPlace> filterdList = new ArrayList<>();

        for(ItemPlace item: items) {

            if(item.geteName().toLowerCase().contains(s.toLowerCase()))
            {
                filterdList.add(item);
            }

            if(filterdList.isEmpty())
            {

                placeAdapter.setFilteredList(filterdList);
                noresultsfound.setText("No results not found..");
                Toast.makeText(getContext(), "Place not found..",Toast.LENGTH_SHORT);

            }else {

                noresultsfound.setText("");
                placeAdapter.setFilteredList(filterdList);

            }

        }

    }
}