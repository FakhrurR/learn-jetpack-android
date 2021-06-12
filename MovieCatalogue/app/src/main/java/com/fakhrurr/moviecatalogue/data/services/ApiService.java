package com.fakhrurr.moviecatalogue.data.services;

import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
        @GET("movie/now_playing")
        Call<NowPlayingResponse> getMovieNowPlaying();


}
