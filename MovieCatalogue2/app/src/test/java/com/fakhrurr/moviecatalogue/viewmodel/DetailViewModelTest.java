package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.utils.FakeDataDummy;
import com.fakhrurr.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;
import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {
    private final Resource<MovieEntity> dummyNowPlaying = Resource.success(FakeDataDummy.getMovies().get(0));
    private final int movieId;

    {
        assert dummyNowPlaying.data != null;
        movieId = dummyNowPlaying.data.getId();
    }

    private final Resource<MovieEntity> dummyAiringToday = Resource.success(FakeDataDummy.getTvShows().get(0));
    private final int tvShowId;

    {
        assert dummyAiringToday.data != null;
        tvShowId = dummyAiringToday.data.getId();
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailMovieModel detailViewModel;

    @Mock
    private MovieRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        detailViewModel = new DetailMovieModel(repository);
    }

    @Test
    public void testMovieDetail() {
        detailViewModel.setId(movieId);
        detailViewModel.setType(MOVIE_TYPE);
        MutableLiveData<Resource<MovieEntity>> movieEntity = new MutableLiveData<>();
        movieEntity.setValue(dummyNowPlaying);

        when(repository.getDetailMovieResponse(movieId)).thenReturn(movieEntity);

        Observer<Resource<MovieEntity>> observer = mock(Observer.class);
        detailViewModel.detail.observeForever(observer);
        verify(observer).onChanged(dummyNowPlaying);
    }

    @Test
    public void testTVShowDetail() {
        detailViewModel.setId(tvShowId);
        detailViewModel.setType(TV_SHOW_TYPE);
        MutableLiveData<Resource<MovieEntity>> tvEntity = new MutableLiveData<>();
        tvEntity.setValue(dummyAiringToday);

        when(repository.getDetailTVShowResponse(tvShowId)).thenReturn(tvEntity);

        Observer<Resource<MovieEntity>> observer = mock(Observer.class);
        detailViewModel.detail.observeForever(observer);
        verify(observer).onChanged(dummyAiringToday);
    }
}