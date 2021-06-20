package com.fakhrurr.moviecatalogue.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.GenreTVShowAdapter;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.GenresItemTVAiringToday;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailTvShowBinding;
import com.fakhrurr.moviecatalogue.viewmodel.DetailTVShowModel;
import com.fakhrurr.moviecatalogue.viewmodel.TVShowViewModalFactory;

import java.util.ArrayList;

import static com.fakhrurr.moviecatalogue.data.services.ApiConfig.BASE_URL_IMAGE;

public class DetailTvShowActivity extends AppCompatActivity {
    public static String EXTRA_COURSE = "extra_course";
    public ActivityDetailTvShowBinding activityDetailTvShowBinding;
    private DetailTVShowModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(getLayoutInflater());
        setContentView(activityDetailTvShowBinding.getRoot());

        TVShowViewModalFactory tvShowViewModalFactory = TVShowViewModalFactory.getINSTANCE(this);
        viewModel = new ViewModelProvider(this, tvShowViewModalFactory).get(DetailTVShowModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.title_detail_tv_show);
        }

        int tvId = getIntent().getIntExtra(EXTRA_COURSE, 0);
        Log.d("TAG", "onCreate: " + tvId);
        viewModel.setSelectedTvShow(tvId);
        loadingProgressBar();
        tvShowDetail();
    }

    private void tvShowDetail() {
        viewModel.getDetailTVShow().observe(this, detailTVResponse -> {
            Glide.with(this)
                    .asBitmap()
                    .load(BASE_URL_IMAGE + detailTVResponse.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(activityDetailTvShowBinding.detailContent.imagePoster);
            activityDetailTvShowBinding.detailContent.textTitle.setText(detailTVResponse.getName());
            activityDetailTvShowBinding.detailContent.contentTextDescription.setText(detailTVResponse.getOverview());
            initRecycleViewGenre(detailTVResponse);
            activityDetailTvShowBinding.detailContent.textDate.setText(detailTVResponse.getFirstAirDate());
        });
    }

    private void loadingProgressBar() {
        viewModel.isLoading().observe(this, aBoolean -> {
            if(aBoolean) {
                activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.VISIBLE);
                activityDetailTvShowBinding.detailContent.movieBackground.setVisibility(View.GONE);
            } else {
                activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.GONE);
                activityDetailTvShowBinding.detailContent.movieBackground.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initRecycleViewGenre(DetailTVResponse detailTVResponse) {
        GenreTVShowAdapter genreAdapter = new GenreTVShowAdapter();
        ArrayList<GenresItemTVAiringToday> genresItems = new ArrayList<>(detailTVResponse.getGenres());
        genreAdapter.setGenresItemList(genresItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        activityDetailTvShowBinding.detailContent.rvGenre.setLayoutManager(linearLayoutManager);
        activityDetailTvShowBinding.detailContent.rvGenre.setHasFixedSize(true);
        activityDetailTvShowBinding.detailContent.rvGenre.setAdapter(genreAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}