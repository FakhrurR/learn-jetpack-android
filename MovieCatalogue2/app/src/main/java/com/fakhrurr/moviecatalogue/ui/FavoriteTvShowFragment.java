package com.fakhrurr.moviecatalogue.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fakhrurr.moviecatalogue.adapters.FavoriteAdapter;
import com.fakhrurr.moviecatalogue.databinding.FavoriteTvShowFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.FavoriteTvShowViewModel;
import com.fakhrurr.moviecatalogue.viewmodel.ViewModalFactory;

import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;

public class FavoriteTvShowFragment extends Fragment {

    private FavoriteTvShowViewModel mViewModel;

    private FavoriteTvShowFragmentBinding favoriteTvShowFragmentBinding;

    public static FavoriteTvShowFragment newInstance() {
        return new FavoriteTvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        favoriteTvShowFragmentBinding = FavoriteTvShowFragmentBinding.inflate(getLayoutInflater());
        return favoriteTvShowFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModalFactory viewModalFactory = ViewModalFactory.getINSTANCE(getActivity());
            mViewModel = new ViewModelProvider(this, viewModalFactory).get(FavoriteTvShowViewModel.class);

            favoriteTvShowFragmentBinding.progressBarFavorite.setVisibility(View.VISIBLE);
            mViewModel.setType(TV_SHOW_TYPE);

            FavoriteAdapter adapter = new FavoriteAdapter();
            mViewModel.favoriteMovies.observe(getActivity(), pagedListResource -> {
                if (pagedListResource.data != null) {
                    favoriteTvShowFragmentBinding.progressBarFavorite.setVisibility(View.GONE);
                    if(pagedListResource.data.size() < 1) {
                        favoriteTvShowFragmentBinding.textEmptyFavTvShow.setVisibility(View.VISIBLE);
                        favoriteTvShowFragmentBinding.rvFavoriteTvShow.setVisibility(View.GONE);
                    } else {
                        favoriteTvShowFragmentBinding.textEmptyFavTvShow.setVisibility(View.GONE);
                        adapter.submitList(pagedListResource.data);
                        adapter.notifyDataSetChanged();
                    }
                }
            });

            favoriteTvShowFragmentBinding.rvFavoriteTvShow.setLayoutManager(new GridLayoutManager(getContext(), 1));
            favoriteTvShowFragmentBinding.rvFavoriteTvShow.setHasFixedSize(true);
            favoriteTvShowFragmentBinding.rvFavoriteTvShow.setAdapter(adapter);
        }
    }
}