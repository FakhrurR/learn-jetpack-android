package com.fakhrurr.moviecatalogue.utils;

import android.net.Uri;

import com.fakhrurr.moviecatalogue.R;

import java.util.Objects;

public class Helpers {
    public Helpers() {}

    public String getURLForResource(int resourceId) {
        return Uri.parse("android.resource://"+ Objects.requireNonNull(R.class.getPackage()).getName()+"/" +resourceId).toString();
    }
}
