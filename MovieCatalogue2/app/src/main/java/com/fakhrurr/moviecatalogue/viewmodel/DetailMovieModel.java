package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItem;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import java.util.List;

import static java.lang.Integer.parseInt;

public class DetailMovieModel extends ViewModel {
    private int movieId;
    private MovieRepository movieRepository;

    public DetailMovieModel(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public void setSelectedMovie(int movieId) {
        this.movieId = movieId;
    }

    public LiveData<List<ResultsItem>> getNowPlaying() {
        return movieRepository.getListNowPlaying();
    }

    public LiveData<DetailMovieResponse> getDetailMovie() {
        return movieRepository.getDetailMovieResponse(movieId);
    }

    public LiveData<Boolean> isLoading() {
        return movieRepository.isLoading();
    }
}
