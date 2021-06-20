package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;

public class DetailTVShowModel extends ViewModel {
    private static final String TAG = MovieViewModel.class.getSimpleName();
    private final TvShowRepository tvShowRepository;
    private int tvShowId;

    public DetailTVShowModel(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public void setSelectedTvShow(int tvId) {
        this.tvShowId = tvId;
    }

    public LiveData<Boolean> isLoading() {
        return tvShowRepository.isLoading();
    }

    public LiveData<DetailTVResponse> getDetailTVShow() {
        return tvShowRepository.getDetailTVShowResponse(tvShowId);
    }
}
