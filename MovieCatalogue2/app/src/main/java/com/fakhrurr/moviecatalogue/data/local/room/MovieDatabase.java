package com.fakhrurr.moviecatalogue.data.local.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;

@Database(entities = {MovieEntity.class},
        version = 2,
        exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();

    private static volatile MovieDatabase INSTANCE;

    public static MovieDatabase getINSTANCE(Context context) {
        if(INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MovieDatabase.class, "movies.db").build();
            }
        }
        return INSTANCE;
    }

}

