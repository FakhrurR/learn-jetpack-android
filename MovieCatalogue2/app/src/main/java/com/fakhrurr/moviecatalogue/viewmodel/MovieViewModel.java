package com.fakhrurr.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private MovieRepository movieRepository;

    public MovieViewModel(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public LiveData<Boolean> isLoading() {
        return movieRepository.isLoading();
    }

    public LiveData<List<ResultsItemNowPlaying>> getNowPlaying(){
        return movieRepository.getListNowPlaying();
    }
}