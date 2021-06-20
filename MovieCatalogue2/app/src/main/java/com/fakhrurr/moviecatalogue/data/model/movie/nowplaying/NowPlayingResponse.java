package com.fakhrurr.moviecatalogue.data.model.movie.nowplaying;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowPlayingResponse {

    @SerializedName("dates")
    private Dates dates;

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<ResultsItemNowPlaying> results;

    @SerializedName("total_results")
    private int totalResults;

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<ResultsItemNowPlaying> getResults() {
        return results;
    }

    public void setResults(List<ResultsItemNowPlaying> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}