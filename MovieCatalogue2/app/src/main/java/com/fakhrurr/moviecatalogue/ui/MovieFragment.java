package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fakhrurr.moviecatalogue.adapters.MovieAdapter;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.databinding.MovieFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.MovieModalFactory;
import com.fakhrurr.moviecatalogue.viewmodel.MovieViewModel;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private MovieViewModel mViewModel;
    private MovieFragmentBinding movieFragmentBinding;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        movieFragmentBinding = MovieFragmentBinding.inflate(getLayoutInflater());
        return movieFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MovieModalFactory movieModalFactory = MovieModalFactory.getINSTANCE(getContext());
        mViewModel = new ViewModelProvider(this, movieModalFactory).get(MovieViewModel.class);
        if (getActivity() != null) {
            mViewModel.getNowPlaying().observe(getActivity(), resultsItems -> {
                movieFragmentBinding.emptyData.setVisibility(View.GONE);
                ArrayList<ResultsItemMovie> listNowPlaying = new ArrayList<>(resultsItems);
                MovieAdapter adapter = new MovieAdapter();
                adapter.setMovies(listNowPlaying);
                movieFragmentBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
                movieFragmentBinding.rvMovie.setHasFixedSize(true);
                movieFragmentBinding.rvMovie.setAdapter(adapter);

                if (listNowPlaying.isEmpty()) {
                    movieFragmentBinding.emptyData.setVisibility(View.VISIBLE);
                }
            });

            mViewModel.isLoading().observe(getActivity(), aBoolean -> {
                if (aBoolean) {
                    movieFragmentBinding.progressBar.setVisibility(View.VISIBLE);
                } else {
                    movieFragmentBinding.progressBar.setVisibility(View.GONE);
                }
            });
        }
    }
}