package com.fakhrurr.moviecatalogue.data.repository.source;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItem;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailMovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailTVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.MovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.TVShowCallback;
import com.fakhrurr.moviecatalogue.utils.EspressoIdlingResource;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private Context context;
    private static String TAG = RemoteDataSource.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static RemoteDataSource INSTANCE;

    public static RemoteDataSource getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public void getTVAiringToday(TVShowCallback tvShowCallback) {
        EspressoIdlingResource.increment();
        Call<TVAiringTodayResponse> tvAiringTodayResponseCall = ApiConfig.getApiService().getTVAiringToday();
        tvAiringTodayResponseCall.enqueue(new Callback<TVAiringTodayResponse>() {
            @Override
            public void onResponse(@NotNull Call<TVAiringTodayResponse> call, @NotNull Response<TVAiringTodayResponse> response) {
                if (response.isSuccessful()) {
                    if(response.body() != null) {
                        tvShowCallback.onResponseSuccess(response.body().getResults());
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<TVAiringTodayResponse> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                EspressoIdlingResource.decrement();
            }
        });
    }

    public void getDetailTVShow(int id, DetailTVShowCallback detailTVShowCallback) {
        EspressoIdlingResource.increment();
        Call<DetailTVResponse> detailTVResponseCall = ApiConfig.getApiService().getDetailTVShow(id);
        detailTVResponseCall.enqueue(new Callback<DetailTVResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailTVResponse> call, @NotNull Response<DetailTVResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        DetailTVResponse detailTVResponse = response.body();
                        detailTVShowCallback.onResponseSuccess(detailTVResponse);
                    }
                } else {
                    detailTVShowCallback.onResponseError(response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<DetailTVResponse> call, @NotNull Throwable t) {
                EspressoIdlingResource.decrement();
                detailTVShowCallback.onResponseError(t.getMessage());
            }
        });
    }

    public void getDetailMovie(int id, DetailMovieCallback detailMovieCallback) {
        EspressoIdlingResource.increment();
        Call<DetailMovieResponse> detailMovieResponseCall = ApiConfig.getApiService().getDetailMovie(id);
        detailMovieResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(Call<DetailMovieResponse> call, Response<DetailMovieResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        DetailMovieResponse detailMovieResponse = response.body();
                        detailMovieCallback.onResponseSuccess(detailMovieResponse);
                    }
                } else {
                    detailMovieCallback.onResponseError(response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<DetailMovieResponse> call, Throwable t) {
                detailMovieCallback.onResponseError(t.getMessage());
                EspressoIdlingResource.decrement();
            }
        });
    }

    public void getNowPlaying(MovieCallback callback) {
        EspressoIdlingResource.increment();
        Call<NowPlayingResponse> responseCall = ApiConfig.getApiService().getMovieNowPlaying();
        responseCall.enqueue(new Callback<NowPlayingResponse>() {
            @Override
            public void onResponse(Call<NowPlayingResponse> call, Response<NowPlayingResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onResponseSuccess(response.body().getResults());
                    }
                } else {
                    callback.onResponseError(response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(Call<NowPlayingResponse> call, Throwable t) {
                callback.onResponseError(t.getMessage());
                EspressoIdlingResource.decrement();
            }
        });
    }
}
