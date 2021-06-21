package com.fakhrurr.moviecatalogue.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailTVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.TVShowCallback;
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

public class TVShowRepositoryTest {
    private final RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private final FakeTVShowRepository fakeTVShowRepository = new FakeTVShowRepository(remote);
    private final List<ResultsItemTVAiringToday> tvAiringTodays = DummyData.generateDummyTVAiringToday();
    private final DetailTVResponse detailTVResponse = DummyData.generateDummyDetailTVAiringToday();
    private final int tvId = detailTVResponse.getId();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void testGetAiringToday() {
        doAnswer(invocation -> {
            ((TVShowCallback) invocation.getArgument(0)).onResponseSuccess(tvAiringTodays);
            return null;
        }).when(remote).getTVAiringToday(any(TVShowCallback.class));
        List<ResultsItemTVAiringToday> resultsItemTVAiringTodays = LiveDataTestUtil.getValue(fakeTVShowRepository.getListTVAiringToday());
        verify(remote).getTVAiringToday(any(TVShowCallback.class));
        assertNotNull(resultsItemTVAiringTodays);
        assertEquals(resultsItemTVAiringTodays.size(), tvAiringTodays.size());
    }

    @Test
    public void testDetailAiringToday() {
        doAnswer(invocation -> {
            ((DetailTVShowCallback) invocation.getArgument(1)).onResponseSuccess(detailTVResponse);
            return null;
        }).when(remote).getDetailTVShow(eq(tvId), any(DetailTVShowCallback.class));
        DetailTVResponse detailTVResponse = LiveDataTestUtil.getValue(fakeTVShowRepository.getDetailTVShowResponse(tvId));
        verify(remote).getDetailTVShow(eq(tvId), any(DetailTVShowCallback.class));

        assertNotNull(detailTVResponse);
        assertNotNull(detailTVResponse.getName());
        assertNotNull(detailTVResponse.getPosterPath());
        assertNotNull(detailTVResponse.getOverview());
        assertNotNull(detailTVResponse.getFirstAirDate());
        assertEquals(detailTVResponse.getVoteAverage(), detailTVResponse.getVoteAverage(), 0);
    }
}
