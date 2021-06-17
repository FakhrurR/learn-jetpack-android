package com.fakhrurr.moviecatalogue.data.callback;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;

import java.util.List;

public interface TVShowCallback {
     void onResponseSuccess(List<ResultsItem> results);
     void onResponseError(String err);
}
