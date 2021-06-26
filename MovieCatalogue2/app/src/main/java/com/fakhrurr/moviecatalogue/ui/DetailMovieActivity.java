package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.adapters.GenreMovieAdapter;
import com.fakhrurr.moviecatalogue.data.local.entity.GenresItem;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.ActivityDetailMovieBinding;
import com.fakhrurr.moviecatalogue.viewmodel.DetailMovieModel;
import com.fakhrurr.moviecatalogue.viewmodel.ViewModalFactory;

import java.util.ArrayList;

import static com.fakhrurr.moviecatalogue.utils.Constants.BASE_URL_IMAGE;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_TYPE = "extra_type";
    public static String EXTRA_COURSE = "extra_course";
    private ActivityDetailMovieBinding activityDetailBinding;
    private DetailMovieModel viewModel;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());

        ViewModalFactory movieModalFactory = ViewModalFactory.getINSTANCE(this);
        viewModel = new ViewModelProvider(this, movieModalFactory).get(DetailMovieModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.label_detail_movie);
        }

        int movieId = getIntent().getIntExtra(EXTRA_COURSE, 0);
        int movieType = getIntent().getIntExtra(EXTRA_TYPE, 0);
        viewModel.setId(movieId);
        viewModel.setType(movieType);
        showLoading();
        movieDetail();
    }

    private void showLoading() {
        activityDetailBinding.detailContent.progressBar.setVisibility(View.VISIBLE);
        activityDetailBinding.detailContent.movieBackground.setVisibility(View.GONE);
    }

    private void hideLoading() {
        activityDetailBinding.detailContent.progressBar.setVisibility(View.GONE);
        activityDetailBinding.detailContent.movieBackground.setVisibility(View.VISIBLE);
    }

    private void movieDetail() {
       viewModel.detail.observe(this, result -> {
           if(result != null) {
               switch (result.status) {
                   case LOADING:
                       showLoading();
                       break;
                   case SUCCESS:
                       hideLoading();
                       dataDetail(result.data);
                       break;
                   case ERROR:
                       hideLoading();
                       Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
                       break;
               }
           }
       });
    }

    private void dataDetail(MovieEntity movieEntity) {
        activityDetailBinding.detailContent.imagePoster.setTag(movieEntity.getTitle());
        Glide.with(this)
                .load(BASE_URL_IMAGE + movieEntity.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(activityDetailBinding.detailContent.imagePoster);
        activityDetailBinding.detailContent.textTitle.setText(movieEntity.getTitle());
        activityDetailBinding.detailContent.textDate.setText(movieEntity.getReleaseDate());
        activityDetailBinding.detailContent.contentTextDescription.setText(movieEntity.getOverview());
    }

    private void setFavoriteStatus(boolean status) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.favorite_button);
        Log.d("TAG", "setFavoriteStatus: " + status);
        if (status) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_baseline_star_white_24));
            menuItem.setTitle(R.string.remove_from_favorite);
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_baseline_star_border_24));
            menuItem.setTitle(R.string.label_add_favorite);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.favorite_button) {
            viewModel.setFavorite();
        } else {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        this.menu = menu;
        viewModel.detail.observe(this, detail -> {
            if (detail != null) {
                switch (detail.status) {
                    case LOADING:
                        showLoading();
                        break;
                    case SUCCESS:
                        if (detail.data != null) {
                            hideLoading();
                            boolean status = detail.data.isStatus();
                            setFavoriteStatus(status);
                        }
                        break;
                    case ERROR:
                        hideLoading();
                        Toast.makeText(getApplicationContext(), getString(R.string.error_message), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}