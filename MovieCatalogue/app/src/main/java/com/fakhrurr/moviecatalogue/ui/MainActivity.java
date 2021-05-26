package com.fakhrurr.moviecatalogue.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.SectionsPagerAdapter;
import com.fakhrurr.moviecatalogue.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        activityMainBinding.viewPager.setAdapter(sectionsPagerAdapter);
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}