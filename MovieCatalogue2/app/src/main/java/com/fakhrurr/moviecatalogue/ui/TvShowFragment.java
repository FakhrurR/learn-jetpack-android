package com.fakhrurr.moviecatalogue.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fakhrurr.moviecatalogue.adapters.MovieAdapter;
import com.fakhrurr.moviecatalogue.databinding.TvShowFragmentBinding;
import com.fakhrurr.moviecatalogue.viewmodel.TvShowViewModel;
import com.fakhrurr.moviecatalogue.viewmodel.ViewModalFactory;

import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;

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
        try {
            if (getActivity() != null) {
                ViewModalFactory tvShowViewModalFactory = ViewModalFactory.getINSTANCE(getContext());
                mViewModel = new ViewModelProvider(this, tvShowViewModalFactory).get(TvShowViewModel.class);

                tvShowFragmentBinding.progressBar.setVisibility(View.VISIBLE);

                mViewModel.setType(TV_SHOW_TYPE);

                MovieAdapter adapter = new MovieAdapter();
                mViewModel.tvShows.observe(getActivity(), resultsItems -> {
                    Log.d("TAG", "onViewCreated: " + resultsItems);
                    if(resultsItems != null) {
                        switch (resultsItems.status) {
                            case LOADING:
                                tvShowFragmentBinding.progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                tvShowFragmentBinding.progressBar.setVisibility(View.GONE);
                                tvShowFragmentBinding.emptyData.setVisibility(View.GONE);
                                adapter.setMovies(resultsItems.data);
                                adapter.notifyDataSetChanged();
                                break;
                            case ERROR:
                                tvShowFragmentBinding.progressBar.setVisibility(View.GONE);
                                break;
                        }

                        tvShowFragmentBinding.rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
                        tvShowFragmentBinding.rvTvShow.setHasFixedSize(true);
                        tvShowFragmentBinding.rvTvShow.setAdapter(adapter);

//                        if (resultsItems.data.isEmpty()) {
//                            tvShowFragmentBinding.emptyData.setVisibility(View.VISIBLE);
//                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}