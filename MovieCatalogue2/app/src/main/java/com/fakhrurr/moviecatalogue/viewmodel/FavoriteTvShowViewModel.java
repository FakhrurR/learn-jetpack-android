package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.vo.Resource;

public class FavoriteTvShowViewModel extends ViewModel {
    private MutableLiveData<Integer> typeId = new MutableLiveData<>();
    private MovieRepository movieRepository;
    public LiveData<Resource<PagedList<MovieEntity>>> favoriteMovies = Transformations.switchMap(typeId, data -> movieRepository.getFavoriteTvShows());

    public FavoriteTvShowViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void setType(int type) {
        typeId.setValue(type);
    }
}