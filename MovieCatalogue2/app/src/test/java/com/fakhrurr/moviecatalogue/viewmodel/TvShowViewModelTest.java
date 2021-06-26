package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.utils.FakeDataDummy;
import com.fakhrurr.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;
import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvShowViewModel tvShowViewModel;
    @Mock
    private MovieRepository repository;

    @Mock
    private Observer<List<ResultsItemTVAiringToday>> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tvShowViewModel = new TvShowViewModel(repository);
    }

    @Test
    public void testGetTVAiringToday() {
        Resource<List<MovieEntity>> dummyTVShow = Resource.success(FakeDataDummy.getTvShows());
        MutableLiveData<Resource<List<MovieEntity>>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTVShow);

        when(repository.getListAiringToday()).thenReturn(tvShows);
        Observer<Resource<List<MovieEntity>>> observer = mock(Observer.class);

        tvShowViewModel.setType(TV_SHOW_TYPE);
        tvShowViewModel.tvShows.observeForever(observer);
        verify(observer).onChanged(dummyTVShow);
    }
}