package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.MovieAdapter;
import com.fakhrurr.moviecatalogue.databinding.MovieFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.ViewModalFactory;
import com.fakhrurr.moviecatalogue.viewmodel.MovieViewModel;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;

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
        if (getActivity() != null) {
            ViewModalFactory movieModalFactory = ViewModalFactory.getINSTANCE(getContext());
            mViewModel = new ViewModelProvider(this, movieModalFactory).get(MovieViewModel.class);
            Log.d("TAG", "onViewCreated: " + "movie");

            movieFragmentBinding.progressBar.setVisibility(View.VISIBLE);

            mViewModel.setType(MOVIE_TYPE);
            MovieAdapter movieAdapter = new MovieAdapter();
            mViewModel.movies.observe(getActivity(), result -> {
                Log.d("TAG", "onViewCreated: " + result);
                if (result != null) {
                    switch (result.status) {
                        case LOADING:
                            movieFragmentBinding.progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            movieFragmentBinding.progressBar.setVisibility(View.GONE);
                            movieAdapter.setMovies(result.data);
                            movieAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            movieFragmentBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), getString(R.string.error_message), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            movieFragmentBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            movieFragmentBinding.rvMovie.setHasFixedSize(true);
            movieFragmentBinding.rvMovie.setAdapter(movieAdapter);
        }
    }
}