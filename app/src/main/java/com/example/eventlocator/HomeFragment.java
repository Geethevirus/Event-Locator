package com.example.eventlocator;

import android.content.ContentResolver;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView staticRecyclerView;
    private RecyclerView localrv;
    private StaticRevAdapter staticRevAdapter;
    private RecyclerView dynamicReyclerView;

    private EventModel eventModel;
    private LocalEventAdapter localEventAdapter;

    private UpcomingEventAdapter upcomingEventAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        staticRecyclerView = view.findViewById(R.id.static_rv);
        localrv = view.findViewById(R.id.localrv);
        dynamicReyclerView = view.findViewById(R.id.upcomingEventsrv);

        ArrayList<EventCategoryModel>items = new ArrayList<>();

        items.add(new EventCategoryModel(R.drawable.spotify,"Music"));
        items.add(new EventCategoryModel(R.drawable.club,"Clubs"));
        items.add(new EventCategoryModel(R.drawable.concert,"Concert"));
        items.add(new EventCategoryModel(R.drawable.shelves,"Markets"));
        items.add(new EventCategoryModel(R.drawable.restaurant1,"Food"));
        items.add(new EventCategoryModel(R.drawable.restaurant,"Restaurant"));
        items.add(new EventCategoryModel(R.drawable.health,"health"));



        String [] eventNames = getResources().getStringArray(R.array.eventname);
        int [] eventPictures = {R.drawable.theweekendlogo,  R.drawable.propaganda,R.drawable.konka,R.drawable.cafe1632};

        String [] upcomingname = getResources().getStringArray(R.array.eventname);
        String [] upcomingdesc = getResources().getStringArray(R.array.eventdesc);

        int [] upcomingpic = {R.drawable.sinevent,  R.drawable.konkaevent,R.drawable.theweekendevent,R.drawable.propaevent};

        upcomingEventAdapter = new UpcomingEventAdapter(getContext(), upcomingname, upcomingdesc, upcomingpic);
        dynamicReyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        dynamicReyclerView.setAdapter(upcomingEventAdapter);






        localEventAdapter = new LocalEventAdapter(getContext(), eventNames,eventPictures);
        localrv.setAdapter(localEventAdapter);
        localrv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));




        staticRevAdapter = new StaticRevAdapter(getContext(),items);

        staticRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        staticRecyclerView.setAdapter(staticRevAdapter);



    }
}