package com.fakhrurr.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

import java.util.List;

public interface TvShowDataSource {
    LiveData<DetailTVResponse> getDetailTVShowResponse(int id);

    LiveData<List<ResultsItem>> getListTVAiringToday();

    void setSelectedTVShow(int id);

    boolean isLoading(boolean loading);
}
