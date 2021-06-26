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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavoriteMovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FavoriteMovieViewModel viewModel;
    @Mock
    private MovieRepository movieRepository = mock(MovieRepository.class);

    @Before
    public void setUp() {
        viewModel = new FavoriteMovieViewModel(movieRepository);
    }

    @Test
    public void testGetFavoriteMovie() {
        MutableLiveData<Resource<PagedList<MovieEntity>>> dummyFavoriteMovies = new MutableLiveData<>();
        PagedList<MovieEntity> pagedList = mock(PagedList.class);

        dummyFavoriteMovies.setValue(Resource.success(pagedList));
        when(movieRepository.getFavoriteMovies()).thenReturn(dummyFavoriteMovies);

        Observer<Resource<PagedList<MovieEntity>>> observer = mock(Observer.class);
        viewModel.setType(MOVIE_TYPE);
        viewModel.favoriteMovies.observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));
    }
}