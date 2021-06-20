package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
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

public class DetailTVShowModelTest {
    private final DetailTVResponse dummyAiring = DummyData.generateDummyDetailTVAiringToday();
    private final int tvShowId = dummyAiring.getId();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailTVShowModel viewModel;
    @Mock
    private TvShowRepository repository;

    @Mock
    private Observer<DetailTVResponse> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new DetailTVShowModel(repository);
        viewModel.setSelectedTvShow(tvShowId);
    }

    @Test
    public void detailTvShowDetail() {
        DetailTVResponse dummyTVAiring = DummyData.generateDummyDetailTVAiringToday();
        MutableLiveData<DetailTVResponse> detailTVResponseMutableLiveData = new MutableLiveData<>();
        detailTVResponseMutableLiveData.setValue(dummyTVAiring);

        when(repository.getDetailTVShowResponse(tvShowId)).thenReturn(detailTVResponseMutableLiveData);
        DetailTVResponse detailTVResponse = viewModel.getDetailTVShow().getValue();
        verify(repository).getDetailTVShowResponse(tvShowId);
        assertNotNull(detailTVResponse);

        assertEquals(detailTVResponse.getName(), dummyTVAiring.getName());
        assertEquals(detailTVResponse.getId(), dummyTVAiring.getId());
        assertEquals(detailTVResponse.getOverview(), dummyTVAiring.getOverview());
        assertEquals(detailTVResponse.getPosterPath(), dummyTVAiring.getPosterPath());
        assertEquals(detailTVResponse.getVoteAverage(), dummyTVAiring.getVoteAverage(), 0);

        viewModel.getDetailTVShow().observeForever(observer);
        verify(observer).onChanged(dummyTVAiring);
    }
}
