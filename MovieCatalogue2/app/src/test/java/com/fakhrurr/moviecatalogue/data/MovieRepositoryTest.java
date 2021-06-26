package com.fakhrurr.moviecatalogue.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.local.LocalDataSource;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.AppExecutors;
import com.fakhrurr.moviecatalogue.utils.FakeDataDummy;
import com.fakhrurr.moviecatalogue.utils.LiveDataTestUtil;
import com.fakhrurr.moviecatalogue.vo.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieRepositoryTest {
    private final RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private final LocalDataSource localDataSource = Mockito.mock(LocalDataSource.class);;
    private final AppExecutors appExecutors = Mockito.mock(AppExecutors.class);;
    private final FakeMovieRepository fakeMovieRepository = new FakeMovieRepository(remote, localDataSource, appExecutors);
    private final List<MovieEntity> movieResponses = FakeDataDummy.getMovies();
    private final int movieId = movieResponses.get(0).getId();
    private final List<MovieEntity> tvShowResponses = FakeDataDummy.getTvShows();
    private final int tvShowId = tvShowResponses.get(0).getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void testGetNowPlaying() {
        MutableLiveData<List<MovieEntity>> dummyEntities = new MutableLiveData<>();
        dummyEntities.setValue(FakeDataDummy.getMovies());

        when(localDataSource.getMovies()).thenReturn(dummyEntities);

        Resource<List<MovieEntity>> result = LiveDataTestUtil.getValue(fakeMovieRepository.getListNowPlaying());

        verify(localDataSource).getMovies();
        assertNotNull(result.data);
        assertEquals(movieResponses.size(), result.data.size());
    }

    @Test
    public void testGeAiringToday() {
        MutableLiveData<List<MovieEntity>> dummyEntities = new MutableLiveData<>();
        dummyEntities.setValue(FakeDataDummy.getTvShows());

        when(localDataSource.getTVShow()).thenReturn(dummyEntities);

        Resource<List<MovieEntity>> result = LiveDataTestUtil.getValue(fakeMovieRepository.getListAiringToday());

        verify(localDataSource).getTVShow();
        assertNotNull(result.data);
        assertEquals(tvShowResponses.size(), result.data.size());
    }

    @Test
    public void testDetailTVShow() {
        MutableLiveData<MovieEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(FakeDataDummy.getTvShows().get(0));

        when(localDataSource.getTVShowById(tvShowId)).thenReturn(dummyEntity);
        Resource<MovieEntity> result = LiveDataTestUtil.getValue(fakeMovieRepository.getDetailTVShowResponse(tvShowId));
        verify(localDataSource).getTVShowById(tvShowId);

        MovieEntity response = tvShowResponses.get(0);
        MovieEntity resultData = result.data;

        assertNotNull(result.data);
        assertNotNull(result.data.getTitle());
        assertEquals(response.getId(), resultData.getId(), 0);
        assertEquals(response.getTitle(), resultData.getTitle());
        assertEquals(response.getOverview(), resultData.getOverview());
        assertEquals(response.getVoteAverage(), resultData.getVoteAverage(), 0);
        assertEquals(response.getReleaseDate(), resultData.getReleaseDate());
        assertEquals(response.getOriginalLanguage(), resultData.getOriginalLanguage());
        assertEquals(response.getPosterPath(), resultData.getPosterPath());
    }

    @Test
    public void testNowPlaying() {
        MutableLiveData<MovieEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(FakeDataDummy.getMovies().get(0));

        when(localDataSource.getMovieById(movieId)).thenReturn(dummyEntity);
        Resource<MovieEntity> result = LiveDataTestUtil.getValue(fakeMovieRepository.getDetailMovieResponse(movieId));
        verify(localDataSource).getMovieById(movieId);

        MovieEntity response = movieResponses.get(0);
        MovieEntity resultData = result.data;

        assertNotNull(result.data);
        assertNotNull(result.data.getTitle());
        assertEquals(response.getId(), resultData.getId(), 0);
        assertEquals(response.getTitle(), resultData.getTitle());
        assertEquals(response.getOverview(), resultData.getOverview());
        assertEquals(response.getVoteAverage(), resultData.getVoteAverage(), 0);
        assertEquals(response.getReleaseDate(), resultData.getReleaseDate());
        assertEquals(response.getOriginalLanguage(), resultData.getOriginalLanguage());
        assertEquals(response.getPosterPath(), resultData.getPosterPath());
    }
}
