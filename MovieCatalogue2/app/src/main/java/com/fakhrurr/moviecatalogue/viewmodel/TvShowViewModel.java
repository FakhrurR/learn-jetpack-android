package com.fakhrurr.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;
import com.fakhrurr.moviecatalogue.data.services.ApiConfig;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowViewModel extends ViewModel {
    private final TvShowRepository tvShowRepository;

    public TvShowViewModel(TvShowRepository tvShowRepository) {
       this.tvShowRepository = tvShowRepository;
    }

    public LiveData<Boolean> isLoading() {
        return tvShowRepository.isLoading();
    }

    public LiveData<List<ResultsItem>> getAiringToday() {
       return tvShowRepository.getListTVAiringToday();
    }
}