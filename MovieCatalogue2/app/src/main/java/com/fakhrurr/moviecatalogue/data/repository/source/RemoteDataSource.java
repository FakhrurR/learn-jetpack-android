package com.fakhrurr.moviecatalogue.data.repository.source;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
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
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<DetailTVResponse>> getDetailTVShow(int id) {
        EspressoIdlingResource.increment();
        Call<DetailTVResponse> detailTVResponseCall = ApiConfig.getApiService().getDetailTVShow(id);
        MutableLiveData<ApiResponse<DetailTVResponse>> responseMutableLiveData = new MutableLiveData<>();
        detailTVResponseCall.enqueue(new Callback<DetailTVResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailTVResponse> call, @NotNull Response<DetailTVResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        DetailTVResponse resultsItemTVAiringToday = response.body();
                        responseMutableLiveData.setValue(ApiResponse.success(resultsItemTVAiringToday));
                    }
                } else {
                    responseMutableLiveData.setValue(ApiResponse.empty(response.message(), null));
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<DetailTVResponse> call, @NotNull Throwable t) {
                EspressoIdlingResource.decrement();
                responseMutableLiveData.setValue(ApiResponse.error(t.getMessage(), null));
            }
        });

        return responseMutableLiveData;
    }

    public LiveData<ApiResponse<ResultsItemMovie>> getDetailMovie(int id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<ResultsItemMovie>> detailMovieResponseMutableLiveData = new MutableLiveData<>();
        Call<ResultsItemMovie> detailMovieResponseCall = ApiConfig.getApiService().getDetailMovie(id);
        detailMovieResponseCall.enqueue(new Callback<ResultsItemMovie>() {
            @Override
            public void onResponse(@NotNull Call<ResultsItemMovie> call, @NotNull Response<ResultsItemMovie> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ResultsItemMovie detailMovieResponse = response.body();
                        detailMovieResponseMutableLiveData.setValue(ApiResponse.success(detailMovieResponse));
                    }
                } else {
                    detailMovieResponseMutableLiveData.setValue(ApiResponse.empty(response.message(), null));
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<ResultsItemMovie> call, @NotNull Throwable t) {
                EspressoIdlingResource.decrement();
                detailMovieResponseMutableLiveData.setValue(ApiResponse.error(t.getMessage(), null));
            }
        });
        return detailMovieResponseMutableLiveData;
    }

    public LiveData<ApiResponse<List<ResultsItemMovie>>> getNowPlaying() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<ResultsItemMovie>>> resultMovie = new MutableLiveData<>();
        Call<NowPlayingResponse> responseCall = ApiConfig.getApiService().getMovieNowPlaying();
        responseCall.enqueue(new Callback<NowPlayingResponse>() {
            @Override
            public void onResponse(@NotNull Call<NowPlayingResponse> call, @NotNull Response<NowPlayingResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<ResultsItemMovie> resultsItemNowPlayings = response.body().getResults();
                        resultMovie.setValue(ApiResponse.success(resultsItemNowPlayings));
                    }
                } else {
                    resultMovie.setValue(ApiResponse.empty(response.message(), null));
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<NowPlayingResponse> call, @NotNull Throwable t) {
                resultMovie.setValue(ApiResponse.error(t.getMessage(), null));
                EspressoIdlingResource.decrement();
            }
        });
        return resultMovie;
    }

    public LiveData<ApiResponse<List<ResultsItemTVAiringToday>>> getTVAiringToday() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<ResultsItemTVAiringToday>>> resultMovie = new MutableLiveData<>();
        Call<TVAiringTodayResponse> responseCall = ApiConfig.getApiService().getTVAiringToday();
        responseCall.enqueue(new Callback<TVAiringTodayResponse>() {
            @Override
            public void onResponse(@NotNull Call<TVAiringTodayResponse> call, @NotNull Response<TVAiringTodayResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<ResultsItemTVAiringToday> resultsItemTVAiringToday = response.body().getResults();
                        resultMovie.setValue(ApiResponse.success(resultsItemTVAiringToday));
                    }
                } else {
                    resultMovie.setValue(ApiResponse.empty(response.message(), null));
                }
                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NotNull Call<TVAiringTodayResponse> call, @NotNull Throwable t) {
                resultMovie.setValue(ApiResponse.error(t.getMessage(), null));
                EspressoIdlingResource.decrement();
            }
        });
        return resultMovie;
    }
}
