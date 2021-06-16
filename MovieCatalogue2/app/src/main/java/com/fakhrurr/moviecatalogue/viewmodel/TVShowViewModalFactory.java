package com.fakhrurr.moviecatalogue.viewmodel;

import android.content.Context;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.di.Injection;

public class TVShowViewModalFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile TVShowViewModalFactory INSTANCE;
    private TvShowRepository repository;

    public TVShowViewModalFactory(TvShowRepository repository) {
        this.repository = repository;
    }

    public static TVShowViewModalFactory getINSTANCE(Context context) {
        if(INSTANCE != null) {
            synchronized (TVShowViewModalFactory.class) {
                INSTANCE = new TVShowViewModalFactory(Injection.provideTVShowRepository());
            }
        }
        return INSTANCE;
    }


}
