package com.fakhrurr.moviecatalogue.utils;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private static Helpers helpers;
    public DummyData() {}
    public static List<MovieEntity> generateDummyMovie() {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();

        movieEntityArrayList.add(new MovieEntity(
                "1",
                "Alita: Battle Angel (2019)",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "14/02/2019 (US)",
                "Aksi, Cerita Fiksi, Petualangan",
                R.drawable.poster_alita));

        movieEntityArrayList.add(new MovieEntity(
                "2",
                "Aquaman (2018)",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "3",
                "Aquaman (2018)",
                "",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "4",
                "Aquaman (2018)",
                "",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        return movieEntityArrayList;
    }

    public static List<MovieEntity> generateDummyTVShow() {
        ArrayList<MovieEntity> tvShowArrayList = new ArrayList<>();

        tvShowArrayList.add(new MovieEntity(
                "11",
                "Alita",
                "data movie",
                "Senin, 20 April 2020",
                "Rijhal",
                R.drawable.poster_aquaman));

        return tvShowArrayList;
    }

    public static List<MovieEntity> generateAllDummyMovies(String movieId) {
        ArrayList<MovieEntity> movieEntityArrayList = new ArrayList<>();

        movieEntityArrayList.add(new MovieEntity(
                "1",
                "Alita: Battle Angel (2019)",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "14/02/2019 (US)",
                "Aksi, Cerita Fiksi, Petualangan",
                R.drawable.poster_alita));

        movieEntityArrayList.add(new MovieEntity(
                "2",
                "Aquaman (2018)",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "3",
                "Aquaman (2018)",
                "",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "4",
                "Aquaman (2018)",
                "",
                "21/12/2018 (US)",
                "Aksi, Petualangan, Fantasi",
                R.drawable.poster_aquaman));

        movieEntityArrayList.add(new MovieEntity(
                "11",
                "Alita",
                "data movie",
                "Senin, 20 April 2020",
                "Rijhal",
                R.drawable.poster_aquaman));

        return movieEntityArrayList;
    }
}
