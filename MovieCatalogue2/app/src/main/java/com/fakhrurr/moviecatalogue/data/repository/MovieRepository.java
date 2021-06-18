package com.fakhrurr.moviecatalogue.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailMovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.MovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.TVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.source.MovieSourceData;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.EspressoIdlingResource;

import java.util.List;

public class MovieRepository implements MovieSourceData {
    private volatile static MovieRepository INSTANCE = null;
    private static final String TAG = MovieRepository.class.getSimpleName();
    private final RemoteDataSource remoteDataSource;
    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public MovieRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static MovieRepository getINSTANCE(RemoteDataSource remoteDataSource) {
        if(INSTANCE == null) {
            synchronized (MovieRepository.class) {
                INSTANCE = new MovieRepository(remoteDataSource);
            }
        }
        return INSTANCE;
    }

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    @Override
    public LiveData<DetailMovieResponse> getDetailMovieResponse(int id) {
        _isLoading.setValue(true);
        MutableLiveData<DetailMovieResponse> detailMovieResponseMutableLiveData = new MutableLiveData<>();
        remoteDataSource.getDetailMovie(id, new DetailMovieCallback() {
            @Override
            public void onResponseSuccess(DetailMovieResponse detailMovieResponse) {
                _isLoading.setValue(false);
                detailMovieResponseMutableLiveData.setValue(detailMovieResponse);
            }

            @Override
            public void onResponseError(String err) {
                Log.d(TAG, "onResponseError: " + err);
            }
        });
        return detailMovieResponseMutableLiveData;
    }

    @Override
    public LiveData<List<ResultsItem>> getListNowPlaying() {
        _isLoading.setValue(true);
        MutableLiveData<List<ResultsItem>> resultNowPlaying = new MutableLiveData<>();
        remoteDataSource.getNowPlaying(new MovieCallback() {
            @Override
            public void onResponseSuccess(List<ResultsItem> results) {
                _isLoading.setValue(false);
               resultNowPlaying.setValue(results);
            }

            @Override
            public void onResponseError(String err) {
                _isLoading.setValue(false);
            }
        });
        return resultNowPlaying;
    }
}
