package com.fakhrurr.moviecatalogue.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.GenreTVShowAdapter;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.GenresItem;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailTvShowBinding;
import com.fakhrurr.moviecatalogue.viewmodel.DetailTVShowModel;

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
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailTVShowModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.title_detail_tv_show);
        }

        int tvId = getIntent().getIntExtra(EXTRA_COURSE, 0);
        Log.d("TAG", "onCreate: " + tvId) ;
        if (tvId != 0) {
            viewModel.setSelectedTvShow(tvId);
            loadingProgressBar();
            viewModel.getDetailTVShow().observe(this, this::tvShowDetail);
        }
    }

    private void tvShowDetail(DetailTVResponse detailTVResponse) {
        Glide.with(this)
                .asBitmap()
                .load(BASE_URL_IMAGE + detailTVResponse.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(activityDetailTvShowBinding.detailContent.imagePoster);
        activityDetailTvShowBinding.detailContent.textTitle.setText(detailTVResponse.getName());
        activityDetailTvShowBinding.detailContent.contentTextDescription.setText(detailTVResponse.getOverview());
        initRecycleViewGenre(detailTVResponse);
        activityDetailTvShowBinding.detailContent.textDate.setText(detailTVResponse.getFirstAirDate());
    }

    private void loadingProgressBar() {
        viewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.VISIBLE);
                } else {
                    activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initRecycleViewGenre(DetailTVResponse detailTVResponse) {
        GenreTVShowAdapter genreAdapter = new GenreTVShowAdapter();
        ArrayList<GenresItem> genresItems = new ArrayList<>(detailTVResponse.getGenres());
        genreAdapter.setGenresItemList(genresItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        activityDetailTvShowBinding.detailContent.rvGenre.setLayoutManager(linearLayoutManager);
        activityDetailTvShowBinding.detailContent.rvGenre.setHasFixedSize(true);
        activityDetailTvShowBinding.detailContent.rvGenre.setAdapter(genreAdapter);
    }
}