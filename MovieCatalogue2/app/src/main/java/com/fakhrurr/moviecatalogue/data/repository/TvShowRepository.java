package com.fakhrurr.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.viewmodel.TvShowViewModel;

import java.util.ArrayList;
import java.util.List;

public class TvShowRepository implements TvShowDataSource {
    private volatile static TvShowRepository INSTANCE = null;
    private final MutableLiveData<List<ResultsItem>> _listTVShow = new MutableLiveData<>();
    private static final String TAG = TvShowViewModel.class.getSimpleName();

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public LiveData<List<ResultsItem>> getListAiringToday() {
        return _listTVShow;
    }

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    public TvShowRepository() {
    }

    @Override
    public DetailTVResponse getDetailTVShowResponse(int id) {
        return null;
    }

    @Override
    public ArrayList<TVAiringTodayResponse> getListTVAiringToday() {

        return null;
    }
}
