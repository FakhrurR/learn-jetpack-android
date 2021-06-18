package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItem;

import java.util.List;

public interface MovieCallback {
    void onResponseSuccess(List<ResultsItem> results);
    void onResponseError(String err);
}
