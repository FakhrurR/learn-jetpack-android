package com.fakhrurr.moviecatalogue.data.repository.source;

import androidx.lifecycle.LiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.vo.Resource;

import java.util.List;

public interface TvShowDataSource {
    LiveData<Resource<DetailTVResponse>> getDetailTVShowResponse(int id);

    LiveData<Resource<List<ResultsItemTVAiringToday>>> getListTVAiringToday();
}
