package com.fakhrurr.moviecatalogue.data.repository.source;

import android.annotation.SuppressLint;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailMovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailTVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.MovieCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.TVShowCallback;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;
import com.fakhrurr.moviecatalogue.utils.EspressoIdlingResource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    @SuppressLint("StaticFieldLeak")
    private static RemoteDataSource INSTANCE;

    public static RemoteDataSource getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public void getTVAiringToday(TVShowCallback callback) {
        EspressoIdlingResource.increment();
        Call<TVAiringTodayResponse> tvAiringTodayResponseCall = ApiConfig.getApiService().getTVAiringToday();
        tvAiringTodayResponseCall.enqueue(new Callback<TVAiringTodayResponse>() {
            @Override
            public void onResponse(@NotNull Call<TVAiringTodayResponse> call, @NotNull Response<TVAiringTodayResponse> response) {
                if (response.isSuccessful()) {
                    if(response.body() != null) {
                        List<ResultsItemTVAiringToday> resultsItemNowPlaying = response.body().getResults();
                        callback.onResponseSuccess(resultsItemNowPlaying);
                    }
                } else {
                    callback.onResponseError(response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<TVAiringTodayResponse> call, @NotNull Throwable t) {
                callback.onResponseError(t.getMessage());
                EspressoIdlingResource.decrement();
            }
        });
    }

    public void getDetailTVShow(int id, DetailTVShowCallback callback) {
        EspressoIdlingResource.increment();
        Call<DetailTVResponse> detailTVResponseCall = ApiConfig.getApiService().getDetailTVShow(id);
        detailTVResponseCall.enqueue(new Callback<DetailTVResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailTVResponse> call, @NotNull Response<DetailTVResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        DetailTVResponse detailTVResponse = response.body();
                        callback.onResponseSuccess(detailTVResponse);
                    }
                } else {
                    callback.onResponseError(response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<DetailTVResponse> call, @NotNull Throwable t) {
                EspressoIdlingResource.decrement();
                callback.onResponseError(t.getMessage());
            }
        });
    }

    public void getDetailMovie(int id, DetailMovieCallback callback) {
        EspressoIdlingResource.increment();
        Call<DetailMovieResponse> detailMovieResponseCall = ApiConfig.getApiService().getDetailMovie(id);
        detailMovieResponseCall.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailMovieResponse> call, @NotNull Response<DetailMovieResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        DetailMovieResponse detailMovieResponse = response.body();
                        callback.onResponseSuccess(detailMovieResponse);
                    }
                } else {
                    callback.onResponseError(response.message());
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<DetailMovieResponse> call, @NotNull Throwable t) {
                EspressoIdlingResource.decrement();
                callback.onResponseError(t.getMessage());
            }
        });
    }

    public void getNowPlaying(MovieCallback callback) {
        EspressoIdlingResource.increment();
        Call<NowPlayingResponse> responseCall = ApiConfig.getApiService().getMovieNowPlaying();
        responseCall.enqueue(new Callback<NowPlayingResponse>() {
            @Override
            public void onResponse(@NotNull Call<NowPlayingResponse> call, @NotNull Response<NowPlayingResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<ResultsItemNowPlaying> resultsItemNowPlayings = response.body().getResults();
                        callback.onResponseSuccess(resultsItemNowPlayings);
                    }
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<NowPlayingResponse> call, @NotNull Throwable t) {
                callback.onResponseError(t.getMessage());
                EspressoIdlingResource.decrement();
            }
        });
    }
}
