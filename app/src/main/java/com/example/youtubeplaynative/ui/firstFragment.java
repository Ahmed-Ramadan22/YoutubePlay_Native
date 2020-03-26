package com.example.youtubeplaynative.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.youtubeplaynative.R;
import com.example.youtubeplaynative.pojo.YoutubeConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class firstFragment extends Fragment  {

    /**
     * Create by : Ahmedtramadan4@gmail.com
     * data : 26 / 3 / 2020
     */

    private static final String TAG = "FirstFragment";

    private YouTubePlayerView mYoutubePlayer;
    private FloatingActionButton videoPlayfrag1;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;

    private WebView webViewChannel1;
    private CircleImageView icon_Channel1;

    public firstFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG , "onCreate: Starting. ");
         final View view = inflater.inflate(R.layout.fragment_first , container , false);

        // Initialize the Video YoutubePlayer
        mYoutubePlayer = view.findViewById(R.id.video_play_frag1);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                Log.d(TAG , "onCreate: Done Initializing Youtube Player. ");
                List<String> videoList = new ArrayList<>();
                videoList.add("0pYHG0MLU2w");
                videoList.add("OHo64fiWx2k");
                youTubePlayer.loadVideos(videoList);

                //To load all videos in playlist
                //youTubePlayer.loadPlaylist("");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Log.d(TAG , "onCreate: Done Initializing Youtube Player. ");

            }
        };

        // Button to play Video
        videoPlayfrag1 = view.findViewById(R.id.play_floating_btn_frag1);
        videoPlayfrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG , "onCreate: Initializing Youtube Player. ");
                videoPlayfrag1.setVisibility(View.GONE);
                mYoutubePlayer.initialize(YoutubeConfig.getApikey() , mOnInitializedListener);

            }
        });


        //Circle Image View to load the channel in WebView
        icon_Channel1 = view.findViewById(R.id.channel_img_frag1);
        icon_Channel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewChannel1.setVisibility(View.VISIBLE);
                webViewChannel1 = view.findViewById(R.id.webView_Channel1);
                WebSettings webSettings = webViewChannel1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webViewChannel1.loadUrl("https://www.youtube.com/channel/UCoNZZLhPuuRteu02rh7bzsw");
            }
        });

        return view;
    }
}
