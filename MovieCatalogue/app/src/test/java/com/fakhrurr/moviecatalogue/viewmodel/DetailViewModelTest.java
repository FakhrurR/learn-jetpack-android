package com.fakhrurr.moviecatalogue.viewmodel;

import com.fakhrurr.moviecatalogue.R;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DetailViewModelTest {
    private DetailViewModel detailViewModel;
    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel();
    }

    @Test
    public void getMovieDetail() {
        String dummyMovieId = "1";
        String dummyMovieTitle = "Alita: Battle Angel (2019)";
        String dummyDes = "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.";
        String dummyDate = "14/02/2019 (US)";
        String dummyGenre = "Aksi, Cerita Fiksi, Petualangan";
        int dummyImagePath = R.drawable.poster_alita;

        detailViewModel.setSelectedMovie("1");
        assertEquals(dummyMovieId, detailViewModel.getMovie().getMovieId());
        assertEquals(dummyMovieTitle, detailViewModel.getMovie().getTitle());
        assertEquals(dummyDes, detailViewModel.getMovie().getDescription());
        assertEquals(dummyGenre, detailViewModel.getMovie().getGenre());
        assertEquals(dummyDate, detailViewModel.getMovie().getDate());
        assertEquals(dummyImagePath, detailViewModel.getMovie().getImagePath());
    }
}