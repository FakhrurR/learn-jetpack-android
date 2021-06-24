package com.fakhrurr.moviecatalogue.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class GenresItem implements Parcelable {
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "id")
    private int id;

    public GenresItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    protected GenresItem(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<GenresItem> CREATOR = new Creator<GenresItem>() {
        @Override
        public GenresItem createFromParcel(Parcel in) {
            return new GenresItem(in);
        }

        @Override
        public GenresItem[] newArray(int size) {
            return new GenresItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }
}
