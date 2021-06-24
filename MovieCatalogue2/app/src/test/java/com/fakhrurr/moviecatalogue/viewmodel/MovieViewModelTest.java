package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.repository.source.ApiResponse;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel movieViewModel;

    @Mock
    private MovieRepository repository;

    @Mock
    private Observer<List<ResultsItemMovie>> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        movieViewModel = new MovieViewModel(repository);
    }

    @Test
    public void getNowPlaying() {
        List<ResultsItemMovie> dummyNowPlay = DummyData.generateDummyNowPlaying();
        MutableLiveData<ApiResponse<List<ResultsItemMovie>>> resultsItemNowPlayingMutableLiveData = new MutableLiveData<>();
        resultsItemNowPlayingMutableLiveData.setValue(ApiResponse.success(dummyNowPlay));

        when(repository.getListNowPlaying()).thenReturn(resultsItemNowPlayingMutableLiveData);
        List<ResultsItemMovie> resultsItemNowPlayingList = movieViewModel.getNowPlaying().getValue();
        verify(repository).getListNowPlaying();
        assertNotNull(resultsItemNowPlayingList);
        assertEquals(20, resultsItemNowPlayingList.size());

        movieViewModel.getNowPlaying().observeForever(observer);
        verify(observer).onChanged(dummyNowPlay);
    }
}