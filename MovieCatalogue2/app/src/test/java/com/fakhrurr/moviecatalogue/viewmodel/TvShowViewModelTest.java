package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {
    private TvShowViewModel tvShowViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private TvShowRepository repository;

    @Mock
    private Observer<List<ResultsItemTVAiringToday>> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tvShowViewModel = new TvShowViewModel(repository);
    }

    @Test
    public void getTVAiringToday() {
        List<ResultsItemTVAiringToday> dummyAiringToday = DummyData.generateDummyTVAiringToday();
        MutableLiveData<List<ResultsItemTVAiringToday>> resultsItemTVAiringTodays = new MutableLiveData<>();
        resultsItemTVAiringTodays.setValue(dummyAiringToday);

        when(repository.getListTVAiringToday()).thenReturn(resultsItemTVAiringTodays);
        List<ResultsItemTVAiringToday> resultsItemTVAiringToday = tvShowViewModel.getAiringToday().getValue();
        verify(repository).getListTVAiringToday();
        assertNotNull(resultsItemTVAiringToday);
        assertEquals(20, resultsItemTVAiringToday.size());

        tvShowViewModel.getAiringToday().observeForever(observer);
        verify(observer).onChanged(dummyAiringToday);
    }
}