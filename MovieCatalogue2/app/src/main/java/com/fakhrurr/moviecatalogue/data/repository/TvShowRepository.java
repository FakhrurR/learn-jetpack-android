package com.fakhrurr.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.callback.DetailTVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.callback.TVShowCallback;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.data.repository.source.TvShowDataSource;

import java.util.List;

public class TvShowRepository implements TvShowDataSource {
    private static final String TAG = TvShowRepository.class.getSimpleName();
    private volatile static TvShowRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    private TvShowRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static TvShowRepository getINSTANCE(RemoteDataSource remoteDataSource) {
        if (INSTANCE == null) {
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
        MutableLiveData<DetailTVResponse> detailTVResponseMutableLiveData = new MutableLiveData<>();
        _isLoading.setValue(true);
        remoteDataSource.getDetailTVShow(id, new DetailTVShowCallback() {
            @Override
            public void onResponseSuccess(DetailTVResponse detailTVResponse) {
                _isLoading.setValue(false);
                detailTVResponseMutableLiveData.setValue(detailTVResponse);
            }

            @Override
            public void onResponseError(String err) {
                _isLoading.setValue(false);
            }
        });
        return detailTVResponseMutableLiveData;
    }

    @Override
    public LiveData<List<ResultsItemTVAiringToday>> getListTVAiringToday() {
        _isLoading.setValue(true);
        MutableLiveData<List<ResultsItemTVAiringToday>> resultTVAiring = new MutableLiveData<>();
        remoteDataSource.getTVAiringToday(new TVShowCallback() {
            @Override
            public void onResponseSuccess(List<ResultsItemTVAiringToday> results) {
                _isLoading.setValue(false);
                resultTVAiring.setValue(results);
            }

            @Override
            public void onResponseError(String err) {
                _isLoading.setValue(false);
            }
        });
        return resultTVAiring;
    }
}
