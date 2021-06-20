package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;

import java.util.List;

public class DetailMovieModel extends ViewModel {
    private int movieId;
    private final MovieRepository movieRepository;

    public DetailMovieModel(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public void setSelectedMovie(int movieId) {
        this.movieId = movieId;
    }

    public LiveData<List<ResultsItemNowPlaying>> getNowPlaying() {
        return movieRepository.getListNowPlaying();
    }

    public LiveData<DetailMovieResponse> getDetailMovie() {
        return movieRepository.getDetailMovieResponse(movieId);
    }

    public LiveData<Boolean> isLoading() {
        return movieRepository.isLoading();
    }
}
