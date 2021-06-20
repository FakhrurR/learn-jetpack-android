package com.fakhrurr.moviecatalogue.data.repository.callback;

import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

public interface DetailTVShowCallback {
    void onResponseSuccess(DetailTVResponse detailTVResponse);

    void onResponseError(String err);
}
