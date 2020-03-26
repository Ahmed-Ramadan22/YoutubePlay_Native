package com.example.youtubeplaynative.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.youtubeplaynative.R;
import com.example.youtubeplaynative.pojo.YoutubeConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class FourFragment extends Fragment {

    /**
     * Create by : Ahmedtramadan4@gmail.com
     * data : 26 / 3 / 2020
     */

    private static final String TAG = "FourFragment";

    private YouTubePlayerView mYoutubePlayer;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;
    private WebView webViewChannel4;

    public FourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_four, container, false);

        // Initialize the Video YoutubePlayer
        mYoutubePlayer = view.findViewById(R.id.video_play_frag4);
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
        //*****************************************************

        // Button to play Video
        final FloatingActionButton videoPlayfrag4 = view.findViewById(R.id.play_floating_btn_frag4);
        videoPlayfrag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoPlayfrag4.setVisibility(View.GONE);
                mYoutubePlayer.initialize(YoutubeConfig.getApikey() , mOnInitializedListener);

            }
        });

        //Circle Image View to load the channel in WebView
        CircleImageView icon_Channel5 = view.findViewById(R.id.channel_img_frag1);
        icon_Channel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewChannel4.setVisibility(View.VISIBLE);
                webViewChannel4 = view.findViewById(R.id.webView_Channel4);
                WebSettings webSettings = webViewChannel4.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webViewChannel4.loadUrl("https://www.youtube.com/channel/UCnDAXfhnL5j-KhHc1KhvXHw");
            }
        });

        return view;
    }

}
