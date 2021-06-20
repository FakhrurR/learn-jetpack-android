package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.GenreMovieAdapter;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.GenresItemNowPlaying;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailMovieBinding;
import com.fakhrurr.moviecatalogue.viewmodel.DetailMovieModel;
import com.fakhrurr.moviecatalogue.viewmodel.MovieModalFactory;

import java.util.ArrayList;
import java.util.List;

import static com.fakhrurr.moviecatalogue.data.services.ApiConfig.BASE_URL_IMAGE;

public class DetailMovieActivity extends AppCompatActivity {

    public static String EXTRA_COURSE = "extra_course";
    private ActivityDetailMovieBinding activityDetailBinding;
    private DetailMovieModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        MovieModalFactory movieModalFactory = MovieModalFactory.getINSTANCE(this);
        viewModel = new ViewModelProvider(this, movieModalFactory).get(DetailMovieModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.label_detail_movie);
        }

            int movieId = getIntent().getIntExtra(EXTRA_COURSE, 0);
            viewModel.setSelectedMovie(movieId);
            loadingProgress();
            movieDetail();
        }

    private void loadingProgress() {
        viewModel.isLoading().observe(this, loading -> {
            if(loading) {
                activityDetailBinding.detailContent.progressBar.setVisibility(View.VISIBLE);
                activityDetailBinding.detailContent.movieBackground.setVisibility(View.GONE);
            } else {
                activityDetailBinding.detailContent.progressBar.setVisibility(View.GONE);
                activityDetailBinding.detailContent.movieBackground.setVisibility(View.VISIBLE);
            }
        });
    }


    private void movieDetail() {
        viewModel.getDetailMovie().observe(this, movieEntity -> {
            activityDetailBinding.detailContent.imagePoster.setTag(movieEntity.getPosterPath());
            Glide.with(this)
                    .load(BASE_URL_IMAGE + movieEntity.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(activityDetailBinding.detailContent.imagePoster);
            activityDetailBinding.detailContent.textTitle.setText(movieEntity.getTitle());
            activityDetailBinding.detailContent.textDate.setText(movieEntity.getReleaseDate());
            initRecycleViewGenre(movieEntity);
            activityDetailBinding.detailContent.contentTextDescription.setText(movieEntity.getOverview());
        });
    }

    private void initRecycleViewGenre(DetailMovieResponse movieEntity) {
        GenreMovieAdapter genreAdapter = new GenreMovieAdapter();
        ArrayList<GenresItemNowPlaying> genresItemNowPlayingArrayList = new ArrayList<>(movieEntity.getGenres());
        genreAdapter.setGenresItemList(genresItemNowPlayingArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        activityDetailBinding.detailContent.rvGenre.setLayoutManager(linearLayoutManager);
        activityDetailBinding.detailContent.rvGenre.setHasFixedSize(true);
        activityDetailBinding.detailContent.rvGenre.setAdapter(genreAdapter);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}