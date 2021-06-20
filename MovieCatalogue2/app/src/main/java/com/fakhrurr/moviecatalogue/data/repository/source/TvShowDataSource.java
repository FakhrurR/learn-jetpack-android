package com.fakhrurr.moviecatalogue.data.repository.source;

import androidx.lifecycle.LiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

import java.util.List;

public interface TvShowDataSource {
    LiveData<DetailTVResponse> getDetailTVShowResponse(int id);

    LiveData<List<ResultsItemTVAiringToday>> getListTVAiringToday();
}
