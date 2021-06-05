package com.fakhrurr.moviecatalogue.viewmodel;

import com.fakhrurr.moviecatalogue.R;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        String dummyMovieId = "1";
        String dummyMovieTitle = "Alita: Battle Angel (2019)";
        String dummyDes = "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.";
        String dummyDate = "14/02/2019 (US)";
        String dummyGenre = "Aksi, Cerita Fiksi, Petualangan";
        int dummyImagePath = R.drawable.poster_alita;

        assertEquals(dummyMovieId, movieViewModel.getMovies().get(0).getMovieId());
        assertEquals(dummyMovieTitle, movieViewModel.getMovies().get(0).getTitle());
        assertEquals(dummyDes, movieViewModel.getMovies().get(0).getDescription());
        assertEquals(dummyGenre, movieViewModel.getMovies().get(0).getGenre());
        assertEquals(dummyDate, movieViewModel.getMovies().get(0).getDate());
        assertEquals(dummyImagePath, movieViewModel.getMovies().get(0).getImagePath());
    }

    @Test
    public void testCheckMovieLength() {
        assertEquals(10, movieViewModel.getMovies().size());
    }
}