package com.fakhrurr.moviecatalogue.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.SectionsPagerAdapter;
import com.fakhrurr.moviecatalogue.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        activityMainBinding.tabs.setOnNavigationItemSelectedListener(this);
        loadFragment(new MovieFragment());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.tab_movie:
                fragment = new MovieFragment();
                break;
            case R.id.tab_tv_show:
                fragment = new TvShowFragment();
                break;
            case R.id.tab_fav:
                fragment = new FavoriteFragment();
                break;
        }
        loadFragment(fragment);
        return true;
    }
}