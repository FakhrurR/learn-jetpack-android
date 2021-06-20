package com.fakhrurr.moviecatalogue.data.repository.source;

import androidx.lifecycle.LiveData;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;

import java.util.List;

public interface MovieSourceData {
    LiveData<DetailMovieResponse> getDetailMovieResponse(int id);

    LiveData<List<ResultsItemNowPlaying>> getListNowPlaying();

    LiveData<Boolean> isLoading();
}
