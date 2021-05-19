package com.fakhrurr.moviecatalogue.utils;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private static Helpers helpers;

    public static List<MovieEntity> generateDummyMovie() {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();

        movieEntityArrayList.add(new MovieEntity(
                "1",
                "Alita",
                "data movie",
                "Senin, 20 April 2020",
                "Rijhal",
                helpers.getURLForResource(R.drawable.poster_alita)));
        return movieEntityArrayList;
    }

    public static List<MovieEntity> generateDummyTVShow() {
        ArrayList<MovieEntity> tvShowArrayList = new ArrayList<>();

        tvShowArrayList.add(new MovieEntity(
                "1",
                "Alita",
                "data movie",
                "Senin, 20 April 2020",
                "Rijhal",
                helpers.getURLForResource(R.drawable.poster_alita)));

        return tvShowArrayList;
    }
}
