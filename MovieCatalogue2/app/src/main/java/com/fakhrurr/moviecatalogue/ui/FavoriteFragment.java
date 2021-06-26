package com.fakhrurr.moviecatalogue.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.SectionsPagerAdapter;
import com.fakhrurr.moviecatalogue.databinding.FavoriteFragmentBinding;
import com.fakhrurr.moviecatalogue.databinding.MovieFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.FavoriteViewModel;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel mViewModel;
    private FavoriteFragmentBinding favoriteFragmentBinding;

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        favoriteFragmentBinding = FavoriteFragmentBinding.inflate(getLayoutInflater());
        return favoriteFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getActivity(), getChildFragmentManager());
        favoriteFragmentBinding.viewPager.setAdapter(sectionsPagerAdapter);
        favoriteFragmentBinding.tabsFav.setupWithViewPager(favoriteFragmentBinding.viewPager);
    }
}