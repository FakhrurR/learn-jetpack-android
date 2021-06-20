package com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVAiringTodayResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<ResultsItemTVAiringToday> results;

    @SerializedName("total_results")
    private int totalResults;

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

    public List<ResultsItemTVAiringToday> getResults() {
        return results;
    }

    public void setResults(List<ResultsItemTVAiringToday> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}