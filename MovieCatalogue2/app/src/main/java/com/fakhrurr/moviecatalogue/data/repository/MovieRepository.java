package com.fakhrurr.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailMovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.MovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.source.MovieSourceData;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;

import java.util.List;

public class MovieRepository implements MovieSourceData {
    private volatile static MovieRepository INSTANCE = null;
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
        MutableLiveData<DetailMovieResponse> data = new MutableLiveData<>();
        _isLoading.setValue(true);
        remoteDataSource.getDetailMovie(id, new DetailMovieCallback() {
            @Override
            public void onResponseSuccess(DetailMovieResponse detailMovieResponse) {
                _isLoading.setValue(false);
                data.setValue(detailMovieResponse);
            }

            @Override
            public void onResponseError(String err) {
                _isLoading.setValue(false);
            }
        });
        return data;
    }

    @Override
    public LiveData<List<ResultsItemNowPlaying>> getListNowPlaying() {
        MutableLiveData<List<ResultsItemNowPlaying>> listMutableLiveData = new MutableLiveData<>();
        _isLoading.setValue(true);
        remoteDataSource.getNowPlaying(new MovieCallback() {
            @Override
            public void onResponseSuccess(List<ResultsItemNowPlaying> results) {
                _isLoading.setValue(false);
                listMutableLiveData.setValue(results);
            }

            @Override
            public void onResponseError(String err) {
                _isLoading.setValue(false);
            }
        });
        return listMutableLiveData;
    }
}
