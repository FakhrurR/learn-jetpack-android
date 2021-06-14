package com.fakhrurr.moviecatalogue.data.repository;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.TVAiringTodayResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;

import java.util.ArrayList;
import java.util.List;

public interface TvShowDataSource {
    DetailTVResponse getDetailTVShowResponse(int id);

    ArrayList<TVAiringTodayResponse> getListTVAiringToday();
}
