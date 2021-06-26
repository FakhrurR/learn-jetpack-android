package com.fakhrurr.moviecatalogue.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.di.Injection;

public class ViewModalFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile ViewModalFactory INSTANCE;
    private final MovieRepository repository;
    private Context mContext;

    public ViewModalFactory(MovieRepository repository) {
        this.repository = repository;
    }

    public static ViewModalFactory getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (MovieRepository.class) {
                INSTANCE = new ViewModalFactory(Injection.provideMovieRepository(context));
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(repository);
        } else if (modelClass.isAssignableFrom(DetailMovieModel.class)) {
            //noinspection unchecked
            return (T) new DetailMovieModel(repository);
        } else if(modelClass.isAssignableFrom(TvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowViewModel(repository);
        } else if(modelClass.isAssignableFrom(DetailTVShowModel.class)) {
            //noinspection unchecked
            return (T) new DetailTVShowModel(repository);
        } else if(modelClass.isAssignableFrom(FavoriteMovieViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoriteMovieViewModel(repository);
        } else if(modelClass.isAssignableFrom(FavoriteTvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoriteTvShowViewModel(repository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
