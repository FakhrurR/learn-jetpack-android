package com.fakhrurr.moviecatalogue.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.ui.FavoriteFragment;
import com.fakhrurr.moviecatalogue.ui.FavoriteMovieFragment;
import com.fakhrurr.moviecatalogue.ui.FavoriteTvShowFragment;
import com.fakhrurr.moviecatalogue.ui.MovieFragment;
import com.fakhrurr.moviecatalogue.ui.TvShowFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.label_movie, R.string.label_tv_show};
    private final Context mContext;

    public SectionsPagerAdapter(Context mContext, @NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FavoriteMovieFragment();
            case 1:
                return new FavoriteTvShowFragment();
            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
