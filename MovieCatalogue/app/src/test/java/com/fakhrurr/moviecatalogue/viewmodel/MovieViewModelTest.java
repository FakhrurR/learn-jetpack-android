package com.fakhrurr.moviecatalogue.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        String movieTitle = "Alita: Battle Angel (2019)";
        assertEquals(movieTitle, movieViewModel.getMovies().get(0).getTitle());
    }

    @Test
    public void testCheckMovieLength() {
        assertEquals(10, movieViewModel.getMovies().size());
    }
}