package com.fakhrurr.moviecatalogue.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.MovieAdapter;
import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.TvShowFragmentBinding;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.viewmodel.TvShowViewModel;

import java.util.List;

public class TvShowFragment extends Fragment {

    private TvShowViewModel mViewModel;
    private TvShowFragmentBinding tvShowFragmentBinding;

    public static TvShowFragment newInstance() {
        return new TvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        tvShowFragmentBinding = TvShowFragmentBinding.inflate(getLayoutInflater());
        return tvShowFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            tvShowFragmentBinding.emptyData.setVisibility(View.GONE);
            List<MovieEntity> tvShow = DummyData.generateDummyTVShow();
            MovieAdapter adapter = new MovieAdapter();
            adapter.setMovies(tvShow);
            tvShowFragmentBinding.rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            tvShowFragmentBinding.rvTvShow.setHasFixedSize(true);
            tvShowFragmentBinding.rvTvShow.setAdapter(adapter);

            if(tvShow.isEmpty()) {
                tvShowFragmentBinding.emptyData.setVisibility(View.VISIBLE);
            }
        }
    }
}