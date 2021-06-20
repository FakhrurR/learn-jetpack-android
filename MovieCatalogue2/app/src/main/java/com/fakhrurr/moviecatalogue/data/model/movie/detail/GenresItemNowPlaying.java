package com.fakhrurr.moviecatalogue.data.model.movie.detail;

import com.google.gson.annotations.SerializedName;

public class GenresItemNowPlaying {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}