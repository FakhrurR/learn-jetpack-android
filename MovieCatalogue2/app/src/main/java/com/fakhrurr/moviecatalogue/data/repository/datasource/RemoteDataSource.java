package com.fakhrurr.moviecatalogue.data.repository.datasource;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;
import com.fakhrurr.moviecatalogue.data.services.ApiService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private Context context;

    private static RemoteDataSource INSTANCE;


    public static RemoteDataSource getINSTANCE() {
        if(INSTANCE != null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public void getTVAiringToday(TVShowCallback tvShowCallback) {
        Call<TVAiringTodayResponse> tvAiringTodayResponseCall = ApiConfig.getApiService().getTVAiringToday();
        tvAiringTodayResponseCall.enqueue(new Callback<TVAiringTodayResponse>() {
            @Override
            public void onResponse(@NotNull Call<TVAiringTodayResponse> call, @NotNull Response<TVAiringTodayResponse> response) {
                if (response.isSuccessful()) {
                    if(response.body() != null) {
                        tvShowCallback.onResponseSuccess(response.body().getResults());
                    }
                } else {
                    tvShowCallback.onResponseError(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<TVAiringTodayResponse> call, @NotNull Throwable t) {
                tvShowCallback.onResponseError(t.getMessage());
            }
        });
    }

    public void getDetailTVShow(int id, DetailTVShowCallback detailTVShowCallback) {
        Call<DetailTVResponse> detailTVResponseCall = ApiConfig.getApiService().getDetailTVShow(id);
        detailTVResponseCall.enqueue(new Callback<DetailTVResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailTVResponse> call, @NotNull Response<DetailTVResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        List<DetailTVResponse> detailTVResponseList = new ArrayList<>();
                        detailTVResponseList.add(response.body());
                        detailTVShowCallback.onResponseSuccess(detailTVResponseList);
                    }
                } else {
                    detailTVShowCallback.onResponseError(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<DetailTVResponse> call, @NotNull Throwable t) {
                detailTVShowCallback.onResponseError(t.getMessage());
            }
        });
    }
}
