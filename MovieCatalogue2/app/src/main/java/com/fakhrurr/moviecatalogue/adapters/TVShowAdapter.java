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
import com.fakhrurr.moviecatalogue.ui.DetailTvShowActivity;

import java.util.ArrayList;
import java.util.List;

import static com.fakhrurr.moviecatalogue.utils.Constants.BASE_URL_IMAGE;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.ViewHolder> {
    private final ArrayList<MovieEntity> listTvShows = new ArrayList<>();

    public void setTVShow(List<MovieEntity> listTvShow) {
        if (listTvShow == null) return;
        this.listTvShows.clear();
        this.listTvShows.addAll(listTvShow);
    }

    @NonNull
    @Override
    public TVShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMovieBinding binding = ItemListMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowAdapter.ViewHolder holder, int position) {
        MovieEntity resultsItem = listTvShows.get(position);
        holder.bind(resultsItem);
    }

    @Override
    public int getItemCount() {
        return listTvShows.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemListMovieBinding binding;

        public ViewHolder(ItemListMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieEntity resultsItem) {
            binding.titleName.setText(resultsItem.getTitle());
            binding.dateMovie.setText(resultsItem.getReleaseDate());
            binding.rate.setText(String.valueOf(resultsItem.getVoteAverage()));
            binding.descriptionName.setText(resultsItem.getOverview());
            binding.cardItem.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailTvShowActivity.class);
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
