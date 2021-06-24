package com.fakhrurr.moviecatalogue.data.local;

import androidx.lifecycle.LiveData;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieDetailEntity;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.local.room.MovieDao;

import java.util.List;

import javax.sql.DataSource;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private MovieDao movieDao;

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

    public void insertMovies(List<MovieEntity> movieEntityList) {
        movieDao.insertMovies(movieEntityList);
    }

    public LiveData<MovieDetailEntity> getMovieById(int id) {
       return movieDao.getMovieDetailById(id);
    }

    public DataSource.Factory<Integer, MovieEntity> getFavoriteMovies() {
        return movieDao.getFavoriteMovies();
    }

    public DataSource.Factory<Integer, MovieEntity> getFavoriteTvShows() {
        return movieDao.getFavoriteTvShows();
    }

    public void updateFavoriteStatus(MovieEntity movie) {
        movieDao.updateMovie(movie);
    }
}
