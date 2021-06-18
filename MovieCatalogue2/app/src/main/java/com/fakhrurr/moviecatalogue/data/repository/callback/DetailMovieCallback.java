package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;

public interface DetailMovieCallback {
    void onResponseSuccess(DetailMovieResponse detailMovieResponse);
    void onResponseError(String err);
}
