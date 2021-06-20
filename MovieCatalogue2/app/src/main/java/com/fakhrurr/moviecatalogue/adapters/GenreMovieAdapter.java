package com.fakhrurr.moviecatalogue.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fakhrurr.moviecatalogue.data.model.movie.detail.GenresItemNowPlaying;
import com.fakhrurr.moviecatalogue.databinding.ItemGenreBinding;

import java.util.ArrayList;

public class GenreMovieAdapter extends RecyclerView.Adapter<GenreMovieAdapter.ViewHolder> {
    private final ArrayList<GenresItemNowPlaying> genresItemList = new ArrayList<>();

    public void setGenresItemList(ArrayList<GenresItemNowPlaying> genresItemLists) {
        if (genresItemLists == null) return;
        this.genresItemList.clear();
        this.genresItemList.addAll(genresItemLists);
    }

    @NonNull
    @Override
    public GenreMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGenreBinding itemGenreBinding = ItemGenreBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GenreMovieAdapter.ViewHolder(itemGenreBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreMovieAdapter.ViewHolder holder, int position) {
        GenresItemNowPlaying genresItem = genresItemList.get(position);
        holder.bind(genresItem);
    }

    @Override
    public int getItemCount() {
        return genresItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemGenreBinding itemGenreBinding;

        public ViewHolder(ItemGenreBinding itemGenreBinding) {
            super(itemGenreBinding.getRoot());
            this.itemGenreBinding = itemGenreBinding;
        }

        public void bind(GenresItemNowPlaying genresItem) {
            itemGenreBinding.titleGenre.setText(genresItem.getName());
        }
    }
}
