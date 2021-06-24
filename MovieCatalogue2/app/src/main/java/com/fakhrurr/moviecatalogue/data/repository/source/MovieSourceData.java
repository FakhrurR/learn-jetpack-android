package com.fakhrurr.moviecatalogue.data.repository.source;

import androidx.lifecycle.LiveData;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.vo.Resource;

public interface MovieSourceData {
    LiveData<Resource<DetailMovieResponse>> getDetailMovieResponse(int id);

    LiveData<Resource<DetailMovieResponse>> getListNowPlaying();
}
