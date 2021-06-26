package com.fakhrurr.moviecatalogue.di;

import android.content.Context;

import com.fakhrurr.moviecatalogue.data.local.LocalDataSource;
import com.fakhrurr.moviecatalogue.data.local.room.MovieDatabase;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.AppExecutors;

public class Injection {
//    public static TvShowRepository provideTVShowRepository(Context context) {
//        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE();
//
//        return TvShowRepository.getINSTANCE(remoteDataSource);
//    }

    public static MovieRepository provideMovieRepository(Context context) {
        MovieDatabase database = MovieDatabase.getINSTANCE(context);

        LocalDataSource localDataSource = LocalDataSource.getINSTANCE(database.movieDao());
        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE();
        AppExecutors appExecutors = new AppExecutors();

        return MovieRepository.getINSTANCE(remoteDataSource, localDataSource, appExecutors);
    }
}
