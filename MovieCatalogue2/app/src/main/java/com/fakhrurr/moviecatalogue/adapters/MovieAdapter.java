package com.fakhrurr.moviecatalogue.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.ItemListMovieBinding;
import com.fakhrurr.moviecatalogue.ui.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

import static com.fakhrurr.moviecatalogue.utils.Constants.BASE_URL_IMAGE;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final ArrayList<MovieEntity> listMovies = new ArrayList<>();

    public void setMovies(List<MovieEntity> listCourses) {
        if (listCourses == null) return;
        this.listMovies.clear();
        this.listMovies.addAll(listCourses);
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMovieBinding binding = ItemListMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        MovieEntity resultsItem = listMovies.get(position);
        holder.bind(resultsItem);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ItemListMovieBinding binding;

        MovieViewHolder(ItemListMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MovieEntity resultsItem) {
            binding.titleName.setText(resultsItem.getTitle());
            binding.dateMovie.setText(resultsItem.getReleaseDate());
            binding.rate.setText(String.valueOf(resultsItem.getVoteAverage()));
            binding.descriptionName.setText(resultsItem.getOverview());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_COURSE, resultsItem.getId());
                intent.putExtra(DetailMovieActivity.EXTRA_TYPE, resultsItem.getType());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .asBitmap()
                    .load(BASE_URL_IMAGE + resultsItem.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgItem);
        }
    }
}
