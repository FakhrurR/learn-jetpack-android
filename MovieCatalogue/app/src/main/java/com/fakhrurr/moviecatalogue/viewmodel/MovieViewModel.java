package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;

import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    // TODO: Implement the ViewModel
//    private final DummyData dummyData = new DummyData();
//
//    public List<MovieEntity> getMovies() {
//        return DummyData.generateDummyMovie();
//    }

    private final MutableLiveData<List<NowPlayingResponse>> _listMovie = new MutableLiveData<>();
    public LiveData<List<NowPlayingResponse>> getListMovie() {
        return _listMovie;
    }

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

}