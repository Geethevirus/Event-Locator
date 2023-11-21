package com.example.eventlocator;

import android.media.MediaPlayer;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyAdapter>{


    private List<VideoItem> videoItems;

    public VideoAdapter(ArrayList<VideoItem> videoItems) {

        this.videoItems = videoItems;
    }


    @NonNull
    @Override
    public VideoAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_video_container,parent,false);

        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.MyAdapter holder, int position) {

        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {

        return videoItems.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView title;
        TextView desc;
        ProgressBar progressBar;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            title = itemView.findViewById(R.id.videoTitleView);
            desc = itemView.findViewById(R.id.videoDescView);
            progressBar = itemView.findViewById(R.id.vidProgressbar);
        }

        void setVideoData(VideoItem videoItem)
        {

            title.setText(videoItem.getVideoTitle());
            desc.setText(videoItem.getVideoDescription());
            videoView.setVideoPath(videoItem.getVideoURL());


            //Called when the media file is ready for playback.
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();

                    //Full screen videoview without stretching the video
                    //This ratio describes how wide your video is.
                    float videoRatio = mediaPlayer.getVideoWidth() / (float)mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;

                    if(scale >= 1f)
                    {
                        videoView.setScaleX(scale);

                    }else{
                        videoView.setScaleY(1f /  scale);

                    }

                }
            });

            //Interface definition for a callback to be invoked when playback of a media source has completed.

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    mediaPlayer.start();

                }
            });


        }
    }
}
