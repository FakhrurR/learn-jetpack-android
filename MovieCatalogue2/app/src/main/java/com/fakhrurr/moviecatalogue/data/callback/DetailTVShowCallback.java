package com.fakhrurr.moviecatalogue.data.callback;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

import java.util.List;

public interface DetailTVShowCallback {
    void onResponseSuccess(DetailTVResponse detailTVResponse);
    void onResponseError(String err);
}
