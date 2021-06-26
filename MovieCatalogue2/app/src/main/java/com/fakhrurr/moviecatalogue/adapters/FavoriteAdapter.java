package com.fakhrurr.moviecatalogue.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.databinding.ItemListMovieBinding;
import com.fakhrurr.moviecatalogue.ui.DetailMovieActivity;

import static com.fakhrurr.moviecatalogue.utils.Constants.BASE_URL_IMAGE;

public class FavoriteAdapter extends PagedListAdapter<MovieEntity, FavoriteAdapter.FavoriteViewHolder> {
    private static final DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public FavoriteAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMovieBinding binding = ItemListMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        MovieEntity movieEntity = getItem(position);
        if (movieEntity != null) {
            holder.bind(movieEntity);
        }
    }

    public static class FavoriteViewHolder extends RecyclerView.ViewHolder {
        private final ItemListMovieBinding binding;

        public FavoriteViewHolder(ItemListMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieEntity resultsItem) {
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
