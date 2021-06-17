package com.fakhrurr.moviecatalogue.di;

import android.content.Context;

import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.data.repository.datasource.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.JsonHelper;

public class Injection {
    public static TvShowRepository provideTVShowRepository(Context context) {
        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE();

        return TvShowRepository.getINSTANCE(remoteDataSource);
    }
}
