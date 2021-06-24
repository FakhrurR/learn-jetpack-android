package com.fakhrurr.moviecatalogue.data.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieDetailEntity;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * from movieentity")
    LiveData<List<MovieEntity>> getMovies();

    @Transaction
    @Query("SELECT * FROM detailmovieentity WHERE id = :id")
    LiveData<MovieDetailEntity> getMovieDetailById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieEntity> movieEntities);

    @Update
    void updateMovie(MovieEntity movieEntity);

    DataSource.Factory<Integer, MovieEntity> getFavoriteTvShows();
}
