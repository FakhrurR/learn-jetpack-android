package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailTvShowBinding;
import com.fakhrurr.moviecatalogue.viewmodel.DetailMovieModel;
import com.fakhrurr.moviecatalogue.viewmodel.ViewModalFactory;

import static com.fakhrurr.moviecatalogue.utils.Constants.BASE_URL_IMAGE;
import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;

public class DetailTvShowActivity extends AppCompatActivity {
    public static String EXTRA_COURSE = "extra_course";
    public ActivityDetailTvShowBinding activityDetailTvShowBinding;
    private DetailMovieModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(getLayoutInflater());
        setContentView(activityDetailTvShowBinding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.title_detail_tv_show);
        }

        ViewModalFactory factory = ViewModalFactory.getINSTANCE(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailMovieModel.class);
        int tvId = getIntent().getIntExtra(EXTRA_COURSE, 0);
        Log.d("TAG", "onCreate: " + tvId);
        showProgress();
        selectedIdMovie(tvId);
        getInit();
    }

    private void selectedIdMovie(int tvId) {
        if(tvId != 0) {
            viewModel.setId(tvId);
            viewModel.setType(TV_SHOW_TYPE);
        } else {
            finish();
        }
    }

    private void getInit() {
        viewModel.detail.observe(this, entity -> {
            if (entity.data != null) {
                switch (entity.status) {
                    case LOADING:
                        showProgress();
                        break;
                    case SUCCESS:
                        hideProgress();
                        tvShowDetail(entity.data);
                        break;
                    case ERROR:
                        hideProgress();
                        Toast.makeText(getApplicationContext(), getString(R.string.error_message), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showProgress() {
        activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.VISIBLE);
        activityDetailTvShowBinding.detailContent.movieBackground.setVisibility(View.GONE);
    }

    private void hideProgress() {
        activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.GONE);
        activityDetailTvShowBinding.detailContent.movieBackground.setVisibility(View.VISIBLE);
    }

    private void tvShowDetail(MovieEntity resultsItemMovie) {
            activityDetailTvShowBinding.detailContent.imagePoster.setTag(resultsItemMovie.getPosterPath());
            Glide.with(this)
                    .asBitmap()
                    .load(BASE_URL_IMAGE + resultsItemMovie.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(activityDetailTvShowBinding.detailContent.imagePoster);
            activityDetailTvShowBinding.detailContent.textTitle.setText(resultsItemMovie.getTitle());
            activityDetailTvShowBinding.detailContent.contentTextDescription.setText(resultsItemMovie.getOverview());
//            initRecycleViewGenre(detailTVResponse);
            activityDetailTvShowBinding.detailContent.textDate.setText(resultsItemMovie.getReleaseDate());
    }
//
//    private void loadingProgressBar() {
//        viewModel.isLoading().observe(this, aBoolean -> {
//            if (aBoolean) {
//                activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.VISIBLE);
//                activityDetailTvShowBinding.detailContent.movieBackground.setVisibility(View.GONE);
//            } else {
//                activityDetailTvShowBinding.detailContent.progressBar.setVisibility(View.GONE);
//                activityDetailTvShowBinding.detailContent.movieBackground.setVisibility(View.VISIBLE);
//            }
//        });
//    }
//
//    private void initRecycleViewGenre(DetailTVResponse detailTVResponse) {
//        GenreTVShowAdapter genreAdapter = new GenreTVShowAdapter();
//        ArrayList<GenresItemTVAiringToday> genresItems = new ArrayList<>(detailTVResponse.getGenres());
//        genreAdapter.setGenresItemList(genresItems);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        activityDetailTvShowBinding.detailContent.rvGenre.setLayoutManager(linearLayoutManager);
//        activityDetailTvShowBinding.detailContent.rvGenre.setHasFixedSize(true);
//        activityDetailTvShowBinding.detailContent.rvGenre.setAdapter(genreAdapter);
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}