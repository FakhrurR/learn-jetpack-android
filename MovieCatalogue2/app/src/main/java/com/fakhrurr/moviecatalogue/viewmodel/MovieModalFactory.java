package com.fakhrurr.moviecatalogue.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.di.Injection;

public class MovieModalFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile MovieModalFactory INSTANCE;
    private MovieRepository repository;
    private Context mContext;

    public MovieModalFactory(MovieRepository repository) {
        this.repository = repository;
    }

    public static MovieModalFactory getINSTANCE(Context context) {
        if(INSTANCE == null) {
            synchronized (MovieRepository.class) {
                INSTANCE = new MovieModalFactory(Injection.provideMovieRepository(context));
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
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
