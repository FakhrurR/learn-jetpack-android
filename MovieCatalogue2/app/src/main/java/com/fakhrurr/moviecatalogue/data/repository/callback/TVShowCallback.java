package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;

import java.util.List;

public interface TVShowCallback {
     void onResponseSuccess(List<ResultsItem> results);
     void onResponseError(String err);
}
