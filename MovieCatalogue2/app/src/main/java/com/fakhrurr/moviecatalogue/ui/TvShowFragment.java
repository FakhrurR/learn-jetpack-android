package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fakhrurr.moviecatalogue.adapters.TVShowAdapter;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItem;
import com.fakhrurr.moviecatalogue.databinding.TvShowFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.TVShowViewModalFactory;
import com.fakhrurr.moviecatalogue.viewmodel.TvShowViewModel;

import java.util.ArrayList;
import java.util.List;

public class TvShowFragment extends Fragment {

    private TvShowViewModel mViewModel;
    private TvShowFragmentBinding tvShowFragmentBinding;

    public static TvShowFragment newInstance() {
        return new TvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        tvShowFragmentBinding = TvShowFragmentBinding.inflate(getLayoutInflater());
        return tvShowFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(TvShowViewModel.class);
        TVShowViewModalFactory tvShowViewModalFactory = TVShowViewModalFactory.getINSTANCE(getContext());
        mViewModel = new ViewModelProvider(this, tvShowViewModalFactory).get(TvShowViewModel.class);
        if (getActivity() != null) {
            mViewModel.getAiringToday().observe(getActivity(), resultsItems -> {
                tvShowFragmentBinding.emptyData.setVisibility(View.GONE);
                ArrayList<ResultsItem> listAiringToday = new ArrayList<>(resultsItems);
                TVShowAdapter adapter = new TVShowAdapter();
                adapter.setTVShow(listAiringToday);
                tvShowFragmentBinding.rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
                tvShowFragmentBinding.rvTvShow.setHasFixedSize(true);
                tvShowFragmentBinding.rvTvShow.setAdapter(adapter);

                if (listAiringToday.isEmpty()) {
                    tvShowFragmentBinding.emptyData.setVisibility(View.VISIBLE);
                }
            });

            mViewModel.isLoading().observe(getActivity(), aBoolean -> {
                if (aBoolean) {
                    tvShowFragmentBinding.progressBar.setVisibility(View.VISIBLE);
                } else {
                    tvShowFragmentBinding.progressBar.setVisibility(View.GONE);
                }
            });
        }
    }
}