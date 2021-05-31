package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import java.util.List;

import static java.lang.Integer.parseInt;

public class DetailViewModel extends ViewModel {
    private DummyData dummyData;
    private String movieId;

    public void setSelectedMovie(String movieId) {
        this.movieId = movieId;
    }

    public MovieEntity getMovie() {
        MovieEntity movie = null;
        List<MovieEntity> movieEntities = DummyData.generateAllDummyMovies();
        for (int i = 0; i < movieEntities.size(); i++) {
            MovieEntity movieEntity = movieEntities.get(i);
            if (movieEntity.getMovieId().equals(movieId)) {
                movie = movieEntity;
            }
        }
        return movie;
    }

}
