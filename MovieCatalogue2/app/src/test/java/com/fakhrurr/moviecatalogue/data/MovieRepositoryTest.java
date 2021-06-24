package com.fakhrurr.moviecatalogue.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailMovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.MovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class MovieRepositoryTest {
    private final RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private final FakeMovieRepository fakeMovieRepository = new FakeMovieRepository(remote);
    private final List<ResultsItemMovie> nowPlayingArrayList = DummyData.generateDummyNowPlaying();
    private final DetailMovieResponse detailMovieResponse = DummyData.generateDummyDetailNowPlaying();
    private final int movieId = detailMovieResponse.getId();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void testGetNowPlaying() {
        doAnswer(invocation -> {
            ((MovieCallback) invocation.getArgument(0)).onResponseSuccess(nowPlayingArrayList);
            return null;
        }).when(remote).getNowPlaying(any(MovieCallback.class));
        List<ResultsItemMovie> resultsItemNowPlayings = LiveDataTestUtil.getValue(fakeMovieRepository.getListNowPlaying());
        verify(remote).getNowPlaying(any(MovieCallback.class));
        assertNotNull(resultsItemNowPlayings);
        assertEquals(nowPlayingArrayList.size(), resultsItemNowPlayings.size());
    }

    @Test
    public void testDetailNowPlaying() {
        doAnswer(invocation -> {
            ((DetailMovieCallback) invocation.getArgument(1)).onResponseSuccess(detailMovieResponse);
            return null;
        }).when(remote).getDetailMovie(eq(movieId), any(DetailMovieCallback.class));
        DetailMovieResponse movieResponse = LiveDataTestUtil.getValue(fakeMovieRepository.getDetailMovieResponse(movieId));
        verify(remote).getDetailMovie(eq(movieId), any(DetailMovieCallback.class));

        assertNotNull(movieResponse);
        assertNotNull(movieResponse.getTitle());
        assertNotNull(movieResponse.getPosterPath());
        assertNotNull(movieResponse.getOverview());
        assertNotNull(movieResponse.getReleaseDate());
        assertEquals(movieResponse.getVoteAverage(), detailMovieResponse.getVoteAverage(), 0);
    }
}
