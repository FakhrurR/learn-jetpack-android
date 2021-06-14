package com.fakhrurr.moviecatalogue.viewmodel;

import com.fakhrurr.moviecatalogue.R;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TvShowViewModelTest {
    private TvShowViewModel tvShowViewModel;

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel();
    }

    @Test
    public void getTVShow() {
        String dummyTvShowId = "17";
        String dummyTvShowTitle = "Gotham (2014)";
        String dummyDes = "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?";
        String dummyDate = "September 22, 2014";
        String dummyGenre = "Drama, Kejahatan, Sci-fi & Fantasy";
        int dummyImagePath = R.drawable.poster_gotham;

        assertEquals(dummyTvShowId, tvShowViewModel.getTVShow().get(6).getMovieId());
        assertEquals(dummyTvShowTitle, tvShowViewModel.getTVShow().get(6).getTitle());
        assertEquals(dummyDes, tvShowViewModel.getTVShow().get(6).getDescription());
        assertEquals(dummyDate, tvShowViewModel.getTVShow().get(6).getDate());
        assertEquals(dummyGenre, tvShowViewModel.getTVShow().get(6).getGenre());
        assertEquals(dummyImagePath, tvShowViewModel.getTVShow().get(6).getImagePath());
    }

    @Test
    public void testCheckTVShowLength() {
        assertEquals(10, tvShowViewModel.getTVShow().size());
    }
}