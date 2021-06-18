package com.fakhrurr.moviecatalogue.di;

import android.content.Context;

import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;

public class Injection {
    public static TvShowRepository provideTVShowRepository(Context context) {
        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE();

        return TvShowRepository.getINSTANCE(remoteDataSource);
    }

    public static MovieRepository provideMovieRepository(Context context) {
        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE();

        return MovieRepository.getINSTANCE(remoteDataSource);
    }
}
