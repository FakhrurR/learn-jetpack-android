package com.fakhrurr.moviecatalogue.data.repository;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.datasource.RemoteDataSource;
import com.fakhrurr.moviecatalogue.data.repository.datasource.TVShowCallback;

import java.util.ArrayList;
import java.util.List;

public class TvShowRepository implements TvShowDataSource {
    private volatile static TvShowRepository INSTANCE = null;
    private static String TAG = TvShowRepository.class.getSimpleName();
    private int tvId;
    private final RemoteDataSource remoteDataSource;
    private TVShowCallback tvShowCallback;

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    private TvShowRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static TvShowRepository getINSTANCE(RemoteDataSource remoteDataSource) {
        if(INSTANCE != null) {
            synchronized (TvShowRepository.class) {
                INSTANCE = new TvShowRepository(remoteDataSource);
            }
        }
        return INSTANCE;
    }

    public LiveData<Boolean> isLoading() {
        return _isLoading;
    }

    @Override
    public LiveData<DetailTVResponse> getDetailTVShowResponse(int id) {
        return null;
    }

    @Override
    public LiveData<List<ResultsItem>> getListTVAiringToday() {
        final MutableLiveData<List<ResultsItem>> listTVShow = new MutableLiveData<>();
        _isLoading.setValue(true);
        remoteDataSource.getTVAiringToday(new TVShowCallback() {
            @Override
            public void onResponseSuccess(List<ResultsItem> results) {
                _isLoading.setValue(false);
                List<ResultsItem> resultsItemList = new ArrayList<>();
                for(ResultsItem resultsItem: results) {
                    ResultsItem airingItem = new ResultsItem();
                    airingItem.setId(resultsItem.getId());
                    airingItem.setName(resultsItem.getName());
                    airingItem.setFirstAirDate(resultsItem.getFirstAirDate());
                    airingItem.setOverview(resultsItem.getOverview());
                    airingItem.setPosterPath(resultsItem.getPosterPath());
                    airingItem.setVoteAverage(resultsItem.getVoteAverage());
                    resultsItemList.add(airingItem);
                }

                listTVShow.postValue(resultsItemList);
            }

            @Override
            public void onResponseError(String err) {
                Log.d(TAG, "onResponseError: " + err);
                _isLoading.setValue(false);
            }
        });
        return listTVShow;
    }

    @Override
    public void setSelectedTVShow(int id) {
        this.tvId = id;
    }

    @Override
    public boolean isLoading(boolean loading) {
        return loading;
    }


}
