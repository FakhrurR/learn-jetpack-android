package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;

import java.util.List;

public interface TVShowCallback {
    void onResponseSuccess(List<ResultsItemTVAiringToday> results);

    void onResponseError(String err);
}
