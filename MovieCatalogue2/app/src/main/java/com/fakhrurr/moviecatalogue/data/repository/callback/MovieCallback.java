package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;

import java.util.List;

public interface MovieCallback {
    void onResponseSuccess(List<ResultsItemNowPlaying> results);
    void onResponseError(String err);
}
