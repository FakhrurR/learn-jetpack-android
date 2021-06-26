package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.vo.Resource;

public class FavoriteMovieViewModel extends ViewModel {
    private final MutableLiveData<Integer> typeId = new MutableLiveData<>();
    private MovieRepository movieRepository;

    public LiveData<Resource<PagedList<MovieEntity>>> favoriteMovies = Transformations.switchMap(typeId, data -> movieRepository.getFavoriteMovies());

    public FavoriteMovieViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void setType(int type) {
        typeId.setValue(type);
    }
}