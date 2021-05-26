package com.fakhrurr.moviecatalogue.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_COURSE = "extra_course";
    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());
        setSupportActionBar(activityDetailBinding.toolbar);
        activityDetailBinding.toolbar.setTitle("");
    }
}