package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailMovieBinding;
import com.fakhrurr.moviecatalogue.viewmodel.DetailMovieModel;

public class DetailMovieActivity extends AppCompatActivity {

    public static String EXTRA_COURSE = "extra_course";
    private ActivityDetailMovieBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());
        DetailMovieModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailMovieModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Detail");
        }

        String movieId = getIntent().getStringExtra(EXTRA_COURSE);
        if (movieId != null) {
            viewModel.setSelectedMovie(movieId);
            final MovieEntity movieEntity = viewModel.getMovie();
            movieDetail(movieEntity);
        }
    }

    private void movieDetail(MovieEntity movieEntity) {
        activityDetailBinding.detailContent.imagePoster.setTag(movieEntity.getImagePath());
        Glide.with(this)
                .load(movieEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(activityDetailBinding.detailContent.imagePoster);
        activityDetailBinding.detailContent.textTitle.setText(movieEntity.getTitle());
        activityDetailBinding.detailContent.textDate.setText(movieEntity.getDate());
//        activityDetailBinding.detailContent.textGenre.setText(movieEntity.getGenre());
        activityDetailBinding.detailContent.contentTextDescription.setText(movieEntity.getDescription());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}