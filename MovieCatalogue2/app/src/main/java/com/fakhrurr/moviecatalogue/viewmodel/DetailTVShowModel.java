package com.fakhrurr.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTVShowModel extends ViewModel {
    private int tvShowId;
    private static final String TAG = MovieViewModel.class.getSimpleName();
    private final TvShowRepository tvShowRepository;

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
