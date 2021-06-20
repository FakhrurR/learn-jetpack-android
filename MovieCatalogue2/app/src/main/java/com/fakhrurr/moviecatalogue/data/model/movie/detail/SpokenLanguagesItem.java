package com.fakhrurr.moviecatalogue.data.model.movie.detail;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguagesItem {

    @SerializedName("name")
    private String name;

    @SerializedName("iso_639_1")
    private String iso6391;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }
}