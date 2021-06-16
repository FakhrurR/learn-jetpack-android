package com.fakhrurr.moviecatalogue.di;

import android.content.Context;

import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.data.repository.datasource.RemoteDataSource;

public class Injection {
    public static TvShowRepository provideTVShowRepository() {
        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE();

        return TvShowRepository.getINSTANCE(remoteDataSource);
    }
}
