package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;
import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteTvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FavoriteTvShowViewModel viewModel;
    @Mock
    private MovieRepository movieRepository = mock(MovieRepository.class);

    @Before
    public void setUp() {
        viewModel = new FavoriteTvShowViewModel(movieRepository);
    }

    @Test
    public void testFavoriteTVShow() {
        MutableLiveData<Resource<PagedList<MovieEntity>>> dummyFavoriteTVShows = new MutableLiveData<>();
        PagedList<MovieEntity> pagedList = mock(PagedList.class);

        dummyFavoriteTVShows.setValue(Resource.success(pagedList));
        when(movieRepository.getFavoriteTvShows()).thenReturn(dummyFavoriteTVShows);

        Observer<Resource<PagedList<MovieEntity>>> observer = mock(Observer.class);
        viewModel.setType(TV_SHOW_TYPE);
        viewModel.favoriteMovies.observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));
    }
}