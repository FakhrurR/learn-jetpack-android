package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {
    private final DetailMovieResponse dummyNowPlaying = DummyData.generateDummyDetailNowPlaying();
    private final int movieId = dummyNowPlaying.getId();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailMovieModel detailViewModel;
    @Mock
    private MovieRepository repository;

    @Mock
    private Observer<DetailMovieResponse> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        detailViewModel = new DetailMovieModel(repository);
        detailViewModel.setSelectedMovie(movieId);
    }

    @Test
    public void getMovieDetail() {
        DetailMovieResponse dummyNowPlayingMovie = DummyData.generateDummyDetailNowPlaying();
        MutableLiveData<DetailMovieResponse> detailMovieResponseMutableLiveData = new MutableLiveData<>();
        detailMovieResponseMutableLiveData.setValue(dummyNowPlayingMovie);

        when(repository.getDetailMovieResponse(movieId)).thenReturn(detailMovieResponseMutableLiveData);
        DetailMovieResponse detailMovieResponse = detailViewModel.getDetailMovie().getValue();
        verify(repository).getDetailMovieResponse(movieId);
        assertNotNull(detailMovieResponse);

        assertEquals(detailMovieResponse.getTitle(), dummyNowPlayingMovie.getTitle());
        assertEquals(detailMovieResponse.getId(), dummyNowPlayingMovie.getId());
        assertEquals(detailMovieResponse.getOverview(), dummyNowPlayingMovie.getOverview());
        assertEquals(detailMovieResponse.getPosterPath(), dummyNowPlayingMovie.getPosterPath());
        assertEquals(detailMovieResponse.getVoteAverage(), dummyNowPlayingMovie.getVoteAverage(), 0);

        detailViewModel.getDetailMovie().observeForever(observer);
        verify(observer).onChanged(dummyNowPlayingMovie);
    }
}