package com.fakhrurr.moviecatalogue.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TvShowViewModelTest {
    private TvShowViewModel tvShowViewModel;

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel();
    }

    @Test
    public void getTVShow() {
        String tvShowTitle = "Gotham (2014)";
        assertEquals(tvShowTitle, tvShowViewModel.getTVShow().get(6).getTitle());
    }

    @Test
    public void testCheckMovieLength() {
        assertEquals(10, tvShowViewModel.getTVShow().size());
    }
}