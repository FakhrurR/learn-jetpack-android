package com.fakhrurr.moviecatalogue.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.callback.DetailTVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.datasource.RemoteDataSource;
import com.fakhrurr.moviecatalogue.data.callback.TVShowCallback;

import java.util.List;

public class TvShowRepository implements TvShowDataSource {
    private volatile static TvShowRepository INSTANCE = null;
    private static final String TAG = TvShowRepository.class.getSimpleName();
    private final RemoteDataSource remoteDataSource;

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    private TvShowRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static TvShowRepository getINSTANCE(RemoteDataSource remoteDataSource) {
        if(INSTANCE == null) {
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
        _isLoading.setValue(true);
        MutableLiveData<DetailTVResponse> detailTVResponseMutableLiveData = new MutableLiveData<>();
        remoteDataSource.getDetailTVShow(id, new DetailTVShowCallback() {
            @Override
            public void onResponseSuccess(DetailTVResponse detailTVResponse) {
                _isLoading.setValue(false);
                DetailTVResponse response = new DetailTVResponse();
                response.setId(detailTVResponse.getId());
                response.setName(detailTVResponse.getName());
                response.setPosterPath(detailTVResponse.getPosterPath());
                response.setGenres(detailTVResponse.getGenres());
                response.setFirstAirDate(detailTVResponse.getFirstAirDate());
                response.setOverview(detailTVResponse.getOverview());
                response.setVoteAverage(detailTVResponse.getVoteAverage());
                detailTVResponseMutableLiveData.setValue(response);
            }

            @Override
            public void onResponseError(String err) {
                _isLoading.setValue(false);
                Log.d(TAG, "onResponseError: " + err);
            }
        });
        return detailTVResponseMutableLiveData;
    }

    @Override
    public LiveData<List<ResultsItem>> getListTVAiringToday() {
        _isLoading.setValue(true);
        MutableLiveData<List<ResultsItem>> resultsItemMutableLiveData = new MutableLiveData<>();
        remoteDataSource.getTVAiringToday(new TVShowCallback() {
            @Override
            public void onResponseSuccess(List<ResultsItem> results) {
                _isLoading.setValue(false);
                resultsItemMutableLiveData.setValue(results);
            }

            @Override
            public void onResponseError(String err) {
                Log.d(TAG, "onResponseError: "+ err);
                _isLoading.setValue(false);
            }
        });
        return resultsItemMutableLiveData;
    }
}
