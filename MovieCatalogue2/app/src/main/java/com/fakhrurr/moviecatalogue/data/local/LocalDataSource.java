package com.fakhrurr.moviecatalogue.data.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.local.room.MovieDao;

import java.util.List;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final MovieDao movieDao;

    private LocalDataSource(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public static LocalDataSource getINSTANCE(MovieDao movieDao) {
        if(INSTANCE == null) {
            INSTANCE = new LocalDataSource(movieDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getMovies() {
        return movieDao.getMovies();
    }

    public LiveData<MovieEntity> getMovieById(int id) {
       return movieDao.getMovieDetailById(id);
    }

    public LiveData<MovieEntity> getTVShowById(int id) {
        return movieDao.getTVShowDetailById(id);
    }

    public LiveData<List<MovieEntity>> getTVShow() {
        return movieDao.getTVShows();
    }

    public DataSource.Factory<Integer, MovieEntity> getFavoriteMovies() {
        return movieDao.getFavoriteMovies();
    }

    public DataSource.Factory<Integer, MovieEntity> getFavoriteTvShows() {
        return movieDao.getFavoriteTvShows();
    }

    public void insertMovies(List<MovieEntity> movieEntityList) {
        movieDao.insertMovies(movieEntityList);
    }

    public void updateFavoriteStatus(MovieEntity movie) {
        movieDao.updateMovie(movie);
    }

    public int deleteMovie(MovieEntity movieEntity) {
        return movieDao.deleteMovie(movieEntity);
    }
}
