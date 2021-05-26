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

import com.fakhrurr.moviecatalogue.adapters.MovieAdapter;
import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.viewmodel.MovieViewModel;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.databinding.MovieFragmentBinding;

import java.util.List;

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
        mViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        if (getActivity() != null) {
            List<MovieEntity> movie = mViewModel.getMovies();
            MovieAdapter adapter = new MovieAdapter();
            adapter.setMovies(movie);
            movieFragmentBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            movieFragmentBinding.rvMovie.setHasFixedSize(true);
            movieFragmentBinding.rvMovie.setAdapter(adapter);
        }
    }

}