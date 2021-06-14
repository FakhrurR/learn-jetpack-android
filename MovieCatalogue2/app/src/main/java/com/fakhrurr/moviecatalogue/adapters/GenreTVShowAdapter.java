package com.fakhrurr.moviecatalogue.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.GenresItem;
import com.fakhrurr.moviecatalogue.databinding.ItemGenreBinding;

import java.util.ArrayList;
import java.util.List;

public class GenreTVShowAdapter extends RecyclerView.Adapter<GenreTVShowAdapter.ViewHolder> {
    private final List<GenresItem> genresItemList = new ArrayList<>();

    public void setGenresItemList( List<GenresItem> genresItemLists) {
        if (genresItemLists == null) return;
        this.genresItemList.clear();
        this.genresItemList.addAll(genresItemLists);
    }

    @NonNull
    @Override
    public GenreTVShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGenreBinding itemGenreBinding = ItemGenreBinding.inflate(LayoutInflater.from(parent.getContext()) , parent, false);
        return new ViewHolder(itemGenreBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreTVShowAdapter.ViewHolder holder, int position) {
        GenresItem genresItem = genresItemList.get(position);
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

        public void bind(GenresItem genresItem) {
            itemGenreBinding.titleGenre.setText(genresItem.getName());
        }
    }
}
