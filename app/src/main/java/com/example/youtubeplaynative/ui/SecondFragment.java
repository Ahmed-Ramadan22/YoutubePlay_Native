package com.example.youtubeplaynative.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class SecondFragment extends Fragment {

    /**
     * Create by : Ahmedtramadan4@gmail.com
     * data : 26 / 3 / 2020
     */
    private static final String TAG = "SecondFragment";

    private YouTubePlayerView mYoutubePlayer;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;
    private WebView webViewChannel2;


    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.second_fragment, container, false);

        // Initialize the Video YoutubePlayer
        mYoutubePlayer = view.findViewById(R.id.video_play_frag2);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                Log.d(TAG , "onCreate: Done Initializing Youtube Player. ");
                List<String> videoList = new ArrayList<>();
                videoList.add("JXQBdMNDL7k");
                videoList.add("7n9vTYs17_Q");
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
        final FloatingActionButton videoPlayfrag2 = view.findViewById(R.id.play_floating_btn_frag2);
        videoPlayfrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoPlayfrag2.setVisibility(View.GONE);
                mYoutubePlayer.initialize(YoutubeConfig.getApikey() , mOnInitializedListener);

            }
        });

        //Circle Image View to load the channel in WebView
        CircleImageView icon_Channel5 = view.findViewById(R.id.channel_img_frag1);
        icon_Channel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewChannel2.setVisibility(View.VISIBLE);
                webViewChannel2 = view.findViewById(R.id.webView_Channel5);
                WebSettings webSettings = webViewChannel2.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webViewChannel2.loadUrl("https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg");
            }
        });

        return view;
    }


}
