package com.fakhrurr.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTVShowModel extends ViewModel {
    private MutableLiveData<Integer> tvShowId = new MutableLiveData<>();
    private final MutableLiveData<DetailTVResponse> detailTVResponseMutableLiveData = new MutableLiveData<>();
    private static final String TAG = MovieViewModel.class.getSimpleName();

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public LiveData<DetailTVResponse> getDetailTVShow() {
        return detailTVResponseMutableLiveData;
    }

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    public DetailTVShowModel() {
        findTvShowDetail();
    }

    public void setSelectedTvShow(int tvId) {
        Log.d(TAG, "findTvShowDetail: "+ tvId);
        tvShowId.setValue(tvId);
    }

    public void findTvShowDetail() {
        _isLoading.setValue(true);
        Call<DetailTVResponse> detailTVResponseCall = ApiConfig.getApiService().getDetailTVShow(766);
        detailTVResponseCall.enqueue(new Callback<DetailTVResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailTVResponse> call, @NotNull Response<DetailTVResponse> response) {
                _isLoading.setValue(false);
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        detailTVResponseMutableLiveData.setValue(response.body());
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<DetailTVResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.d(TAG, "onResponse: " + t.getMessage());
            }
        });
    }
}
