package com.fakhrurr.moviecatalogue.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel detailViewModel;
    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel();
    }

    @Test
    public void getMovieDetail() {
        String movieTitle = "Alita: Battle Angel (2019)";
        detailViewModel.setSelectedMovie("1");
        assertEquals(movieTitle, detailViewModel.getMovie().getTitle());
    }
}