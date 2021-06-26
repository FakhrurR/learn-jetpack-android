package com.fakhrurr.moviecatalogue.data.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.fakhrurr.moviecatalogue.data.local.entity.GenresItem;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * from movie_entity WHERE type = 1")
    LiveData<List<MovieEntity>> getMovies();

    @Query("SELECT * from movie_entity WHERE type = 2")
    LiveData<List<MovieEntity>> getTVShows();

    @WorkerThread
    @Transaction
    @Query("SELECT * FROM movie_entity WHERE type = 1 AND movieId = :id")
    LiveData<MovieEntity> getMovieDetailById(int id);

    @WorkerThread
    @Transaction
    @Query("SELECT * FROM movie_entity WHERE type = 2 AND movieId = :id")
    LiveData<MovieEntity> getTVShowDetailById(int id);

    @WorkerThread
    @Transaction
    @Query("SELECT * FROM movie_entity WHERE status = 1 AND type = 2")
    DataSource.Factory<Integer, MovieEntity> getFavoriteTvShows();

    @WorkerThread
    @Transaction
    @Query("SELECT * FROM movie_entity WHERE status = 1 AND type = 1")
    DataSource.Factory<Integer, MovieEntity> getFavoriteMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieEntity> movieEntities);

    @Update
    void updateMovie(MovieEntity movieEntity);

    @Delete
    int deleteMovie(MovieEntity movie);
}
