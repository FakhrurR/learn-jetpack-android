package com.fakhrurr.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.BuildConfig;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItem;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private final MutableLiveData<List<ResultsItem>> _listNowPlaying = new MutableLiveData<>();
    private static final String TAG = MovieViewModel.class.getSimpleName();

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public MovieViewModel() {
        getNowPlaying();
    }

    public LiveData<List<ResultsItem>> getListNowPlaying() {
        return _listNowPlaying;
    }

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    public final void getNowPlaying(){
        _isLoading.setValue(true);
        Call<NowPlayingResponse> nowPlayingResponseCall = ApiConfig.getApiService().getMovieNowPlaying();
        nowPlayingResponseCall.enqueue(new Callback<NowPlayingResponse>() {
            @Override
            public void onResponse(@NotNull Call<NowPlayingResponse> call, @NotNull Response<NowPlayingResponse> response) {
                _isLoading.setValue(false);
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        _listNowPlaying.setValue(response.body().getResults());
                    }
                } else {
                    if (response.body() != null) {
                        Log.e(TAG, "onFailure: " + "Error");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<NowPlayingResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}