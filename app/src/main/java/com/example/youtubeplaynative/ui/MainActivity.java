package com.example.youtubeplaynative.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import com.example.youtubeplaynative.R;

public class MainActivity extends AppCompatActivity {

    /**
     * Create by : Ahmedtramadan4@gmail.com
     * data : 26 / 3 / 2020
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        /**
         * Declare The (1) Fragment
         */
        firstFragment firstFragment = new firstFragment();
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.container1, firstFragment)
                .commit();

        /**
         * Declare The (2) Fragment
         */
        SecondFragment secondFragment = new SecondFragment();
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.container2, secondFragment)
                .commit();

        /**
         * Declare The (3) Fragment
         */
        ThirdFragment thirdFragment = new ThirdFragment();
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.container3, thirdFragment)
                .commit();

        /**
         * Declare The (4) Fragment
         */
        FourFragment fourFragment = new FourFragment();
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.container4, fourFragment)
                .commit();

        /**
         * Declare The (5) Fragment
         */
        FiveFragment fiveFragment = new FiveFragment();
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.container5, fiveFragment)
                .commit();

    }
}
