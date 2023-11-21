package com.example.eventlocator;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
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
        Context context = new ContextThemeWrapper(getActivity(),R.style.Fullscreen);
        LayoutInflater localInflator = inflater.cloneInContext(context);

        // Inflate the layout for this fragment
        return localInflator.inflate(R.layout.fragment_explore, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<VideoItem> items = new ArrayList<>();
        final ViewPager2 viewPager2 = view.findViewById(R.id.vidViewPager);

        VideoItem videoItem = new VideoItem();
        VideoItem videoItem1 = new VideoItem();
        VideoItem videoItem2 = new VideoItem();
        videoItem2.setVideoURL("https://firebasestorage.googleapis.com/v0/b/event-locator-51113.appspot.com/o/FridayThe13th%20was%20a%20Scary%20VIBE!%20%20%20%23zone6venue%23mintvenue.mp4?alt=media&token=3dc61a4d-a67b-49db-ae72-ead038fab3c2");
        videoItem2.setVideoTitle("Europa");
        videoItem2.setVideoDescription("Ban nahskhsshb hsb");
        videoItem1.setVideoURL("https://firebasestorage.googleapis.com/v0/b/event-locator-51113.appspot.com/o/K%20%EF%B8%8FNKA%20PICNIC%20%26%20Bloem%20%20%20We%20Only%20Two%20Days%20Away%20%20%20Book%20Your%20Tables%20-%20%2B27%2060%20598%200716%20%20%20don%E2%80%99t%20miss%20out%20on%20this%20amazing%20experience%20%20%20%23KonkaDayPicnic%20%23OperationBloem.mp4?alt=media&token=acf435e9-a02a-48f8-a9a5-33fc208e5a35");
        videoItem1.setVideoTitle("Propaganda");
        videoItem1.setVideoDescription("Proper aagenda we serve :)");

        videoItem.setVideoURL("https://firebasestorage.googleapis.com/v0/b/event-locator-51113.appspot.com/o/Tickets%20on%20bio%E2%80%A6It%E2%80%99s%20almost%20time%20for%20Skhandaville%20Festival%40mrcashtime%20%40kabelomotha_%20%40djmaphorisa%20%40musakeys%40mawhoo_%40moozlie%40cooper_pabi%20%40magleradoeboy%401roili%20%40lokitunez%20%40dj_mrxGet%20your%20tickets%20now%20and%20join%20us%20for%20the%20.mp4?alt=media&token=4e0c6a24-a6b1-490e-aa9e-dda223c05095");
        videoItem.setVideoTitle("Konka");
        videoItem.setVideoDescription("Woza weekend ... silah");
        items.add(videoItem2);
        items.add(videoItem);
        items.add(videoItem1);

        VideoAdapter videoAdpter = new VideoAdapter(items);
        viewPager2.setAdapter(videoAdpter);
    }
}