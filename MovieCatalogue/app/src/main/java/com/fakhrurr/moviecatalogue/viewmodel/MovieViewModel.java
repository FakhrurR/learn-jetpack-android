package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final DummyData dummyData = new DummyData();

    public List<MovieEntity> getMovies() {
        return DummyData.generateDummyMovie();
    }
}