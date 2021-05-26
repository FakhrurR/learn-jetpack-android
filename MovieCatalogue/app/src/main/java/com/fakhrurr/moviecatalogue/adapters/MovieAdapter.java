package com.fakhrurr.moviecatalogue.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.ItemListMovieBinding;
import com.fakhrurr.moviecatalogue.ui.DetailActivity;
import com.fakhrurr.moviecatalogue.ui.MovieFragment;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<MovieEntity> listMovies = new ArrayList<>();

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
        MovieEntity movieEntity = listMovies.get(position);
        holder.bind(movieEntity);
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

        void bind(MovieEntity movieEntity) {
            binding.titleName.setText(movieEntity.getTitle());
            binding.dateMovie.setText(movieEntity.getDate());
            binding.genre.setText(movieEntity.getGenre());
            binding.descriptionName.setText(movieEntity.getDescription());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_COURSE, movieEntity.getMovieId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(movieEntity.getImagePath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgItem);
      }
    }
}
