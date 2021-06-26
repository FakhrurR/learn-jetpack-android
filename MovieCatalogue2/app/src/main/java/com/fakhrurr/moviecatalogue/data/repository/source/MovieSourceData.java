package com.fakhrurr.moviecatalogue.data.repository.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.vo.Resource;

import java.util.List;

public interface  MovieSourceData {
    LiveData<Resource<com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity>> getDetailMovieResponse(int id);

    LiveData<Resource<List<MovieEntity>>> getListNowPlaying();

    LiveData<Resource<MovieEntity>> getDetailTVShowResponse(int id);

    LiveData<Resource<List<MovieEntity>>> getListAiringToday();

    LiveData<Resource<PagedList<MovieEntity>>> getFavoriteMovies();

    LiveData<Resource<PagedList<MovieEntity>>> getFavoriteTvShows();

    void setFavoriteStatus(MovieEntity movieEntity);
}
