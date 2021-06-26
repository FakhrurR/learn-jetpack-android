package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.data.repository.source.ApiResponse;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel movieViewModel;

    @Mock
    private MovieRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        movieViewModel = new MovieViewModel(repository);
    }

    @Test
    public void getNowPlaying() {
        Resource<List<MovieEntity>> dummyMovies = Resource.success(FakeDataDummy.getMovies());
        MutableLiveData<Resource<List<MovieEntity>>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(repository.getListNowPlaying()).thenReturn(movies);
        Observer<Resource<List<MovieEntity>>> observer = mock(Observer.class);

        movieViewModel.setType(MOVIE_TYPE);
        movieViewModel.movies.observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}