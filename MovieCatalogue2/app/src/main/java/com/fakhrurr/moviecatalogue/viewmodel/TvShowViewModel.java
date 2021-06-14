package com.fakhrurr.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowViewModel extends ViewModel {
    private final MutableLiveData<List<ResultsItem>> _listTVShow = new MutableLiveData<>();
    private static final String TAG = TvShowViewModel.class.getSimpleName();

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public TvShowViewModel() {
//        getAiringToday();
    }

    public LiveData<List<ResultsItem>> getListAiringToday() {
        return _listTVShow;
    }

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    public void getAiringToday() {
        _isLoading.setValue(true);
        Call<TVAiringTodayResponse> tvAiringTodayResponseCall = ApiConfig.getApiService().getTVAiringToday();
        tvAiringTodayResponseCall.enqueue(new Callback<TVAiringTodayResponse>() {
            @Override
            public void onResponse(@NotNull Call<TVAiringTodayResponse> call, @NotNull Response<TVAiringTodayResponse> response) {
                _isLoading.setValue(false);
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        _listTVShow.setValue(response.body().getResults());
                    }
                } else {
                    if (response.body() != null) {
                        Log.e(TAG, "onFailure: " + "Error");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<TVAiringTodayResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}