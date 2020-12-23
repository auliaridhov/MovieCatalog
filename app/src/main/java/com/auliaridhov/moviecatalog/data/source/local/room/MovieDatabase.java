package com.auliaridhov.moviecatalog.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;

@Database(entities = {MovieLocalEntity.class, TvShowLocalEntity.class},
        version = 1,
        exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();

    private static volatile MovieDatabase INSTANCE;

    public static MovieDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class, "Movies.db")
                            .build();
                }

            }
        }
        return INSTANCE;
    }
}
