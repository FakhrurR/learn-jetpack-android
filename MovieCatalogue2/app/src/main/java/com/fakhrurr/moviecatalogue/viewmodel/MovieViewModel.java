package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private final MovieRepository movieRepository;

    public MovieViewModel(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public LiveData<Boolean> isLoading() {
        return movieRepository.isLoading();
    }

    public LiveData<List<ResultsItemNowPlaying>> getNowPlaying() {
        return movieRepository.getListNowPlaying();
    }
}