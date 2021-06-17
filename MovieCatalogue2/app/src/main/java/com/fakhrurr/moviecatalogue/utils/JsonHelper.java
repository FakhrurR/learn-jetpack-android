package com.fakhrurr.moviecatalogue.utils;

import android.app.Application;
import android.content.Context;

import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonHelper {
    private Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    private String parsingFileToString(String filename) {
        try {
            InputStream is = context.getAssets().open(filename);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<MovieResponse> loadMovies() {
//        ArrayList<MovieResponse> list = new ArrayList<>();
//
//        try {
//            JSONObject responseObject = new JSONObject(parsingFileToString("movie_response.json"));
//            JSONArray listArray = responseObject.getJSONArray("movies");
//            for (int i = 0; i < listArray.length(); i++) {
//                JSONObject movie = listArray.getJSONObject(i);
//
//                String id = movie.getString("id");
//                String title = movie.getString("title");
//                String releaseDate = movie.getString("release_date");
//                String description = movie.getString("overview");
//                String voteAverage = movie.getString("vote_average");
//                String originalLanguage = movie.getString("original_language");
//                String poster = movie.getString("poster_path");
//
//                MovieResponse movieResponse = new MovieResponse(id, title, releaseDate, description, voteAverage, originalLanguage, poster, MOVIE_TYPE);
//                list.add(movieResponse);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public List<ResultsItem> loadAiringToday() {
        ArrayList<ResultsItem> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(Objects.requireNonNull(parsingFileToString("tv_response.json")));
            JSONArray listArray = responseObject.getJSONArray("results");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject tvShow = listArray.getJSONObject(i);

                int id = tvShow.getInt("id");
                String title = tvShow.getString("name");
                String releaseDate = tvShow.getString("first_air_date");
                String description = tvShow.getString("overview");
                int voteAverage = tvShow.getInt("vote_average");
                String originalLanguage = tvShow.getString("original_language");
                String poster = tvShow.getString("poster_path");

                ResultsItem tvShowResponse = new ResultsItem();
                tvShowResponse.setId(id);
                tvShowResponse.setName(title);
                tvShowResponse.setFirstAirDate(releaseDate);
                tvShowResponse.setOverview(description);
                tvShowResponse.setVoteAverage(voteAverage);
                tvShowResponse.setPosterPath(poster);
                list.add(tvShowResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}