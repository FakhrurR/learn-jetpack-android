package com.fakhrurr.moviecatalogue.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.di.Injection;

public class TVShowViewModalFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile TVShowViewModalFactory INSTANCE;
    private final TvShowRepository repository;
    private Context mContext;

    public TVShowViewModalFactory(TvShowRepository repository) {
        this.repository = repository;
    }

    public static TVShowViewModalFactory getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (TVShowViewModalFactory.class) {
                INSTANCE = new TVShowViewModalFactory(Injection.provideTVShowRepository(context));
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowViewModel(repository);
        } else if (modelClass.isAssignableFrom(DetailTVShowModel.class)) {
            //noinspection unchecked
            return (T) new DetailTVShowModel(repository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
