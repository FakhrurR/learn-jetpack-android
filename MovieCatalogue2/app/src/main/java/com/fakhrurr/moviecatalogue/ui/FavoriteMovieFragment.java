package com.fakhrurr.moviecatalogue.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fakhrurr.moviecatalogue.adapters.FavoriteAdapter;
import com.fakhrurr.moviecatalogue.databinding.FavoriteMovieFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.FavoriteMovieViewModel;
import com.fakhrurr.moviecatalogue.viewmodel.ViewModalFactory;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;

public class FavoriteMovieFragment extends Fragment {

    private FavoriteMovieViewModel mViewModel;

    private FavoriteMovieFragmentBinding favoriteMovieFragmentBinding;

    public static FavoriteMovieFragment newInstance() {
        return new FavoriteMovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        favoriteMovieFragmentBinding = FavoriteMovieFragmentBinding.inflate(getLayoutInflater());
        return favoriteMovieFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModalFactory viewModalFactory = ViewModalFactory.getINSTANCE(getActivity());
            mViewModel = new ViewModelProvider(this, viewModalFactory).get(FavoriteMovieViewModel.class);

            favoriteMovieFragmentBinding.progressBarFavorite.setVisibility(View.VISIBLE);
            mViewModel.setType(MOVIE_TYPE);
            FavoriteAdapter adapter = new FavoriteAdapter();
            mViewModel.favoriteMovies.observe(getActivity(), pagedListResource -> {
                Log.d("TAG", "onViewCreated favorite: " + pagedListResource.data);
                if (pagedListResource.data != null) {
                    favoriteMovieFragmentBinding.progressBarFavorite.setVisibility(View.GONE);
                    if(pagedListResource.data.size() < 1) {
                        favoriteMovieFragmentBinding.textEmptyFavMovie.setVisibility(View.VISIBLE);
                        favoriteMovieFragmentBinding.rvFavoriteMovie.setVisibility(View.GONE);
                    } else {
                        favoriteMovieFragmentBinding.textEmptyFavMovie.setVisibility(View.GONE);
                        adapter.submitList(pagedListResource.data);
                        adapter.notifyDataSetChanged();
                    }
                }


            });
            favoriteMovieFragmentBinding.rvFavoriteMovie.setLayoutManager(new GridLayoutManager(getContext(), 1));
            favoriteMovieFragmentBinding.rvFavoriteMovie.setHasFixedSize(true);
            favoriteMovieFragmentBinding.rvFavoriteMovie.setAdapter(adapter);
        }
    }
}