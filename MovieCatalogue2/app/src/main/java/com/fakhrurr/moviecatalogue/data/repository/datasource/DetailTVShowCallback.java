package com.fakhrurr.moviecatalogue.data.repository.datasource;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

import java.util.List;

public interface DetailTVShowCallback {
    void onResponseSuccess(List<DetailTVResponse> results);
    void onResponseError(String err);
}
