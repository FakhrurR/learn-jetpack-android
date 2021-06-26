package com.fakhrurr.moviecatalogue.data.services;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.NowPlayingResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("movie/now_playing")
    Call<NowPlayingResponse> getMovieNowPlaying();

    @GET("tv/airing_today")
    Call<TVAiringTodayResponse> getTVAiringToday();

    @GET("tv/{tv_id}")
    Call<DetailTVResponse> getDetailTVShow(@Path("tv_id") int id);

    @GET("movie/{movie_id}")
    Call<ResultsItemMovie> getDetailMovie(@Path("movie_id") int id);
}
