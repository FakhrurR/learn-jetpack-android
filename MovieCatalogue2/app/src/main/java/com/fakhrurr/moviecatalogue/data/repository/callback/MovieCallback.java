package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;

import java.util.List;

public interface MovieCallback {
    void onResponseSuccess(List<ResultsItemMovie> results);

    void onResponseError(String err);
}
