package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    // TODO: Implement the ViewModel
//    private final DummyData dummyData = new DummyData();
//
//    public List<MovieEntity> getTVShow() {
//        return DummyData.generateDummyTVShow();
//    }
    private final MutableLiveData<List<TVAiringTodayResponse>> _listTVShow = new MutableLiveData<>();
    public LiveData<List<TVAiringTodayResponse>> getListTVShow() {
        return _listTVShow;
    }

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();
    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }
}