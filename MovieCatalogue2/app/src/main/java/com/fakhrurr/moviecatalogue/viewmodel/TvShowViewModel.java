package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.repository.TvShowRepository;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private final TvShowRepository tvShowRepository;

    public TvShowViewModel(TvShowRepository tvShowRepository) {
       this.tvShowRepository = tvShowRepository;
    }

    public LiveData<Boolean> isLoading() {
        return tvShowRepository.isLoading();
    }

    public LiveData<List<ResultsItemTVAiringToday>> getAiringToday() {
       return tvShowRepository.getListTVAiringToday();
    }
}