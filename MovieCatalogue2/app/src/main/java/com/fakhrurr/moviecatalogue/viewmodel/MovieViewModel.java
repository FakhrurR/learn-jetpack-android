package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepository movieRepository;

    private final MutableLiveData<Integer> result = new MutableLiveData<Integer>();

    public MovieViewModel(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public LiveData<Resource<List<MovieEntity>>> movies = Transformations.switchMap(result, data -> movieRepository.getListNowPlaying());

    public void setType(int type) {
        result.setValue(type);
    }
}