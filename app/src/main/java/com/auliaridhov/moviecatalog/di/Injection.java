package com.auliaridhov.moviecatalog.di;

import android.content.Context;

import com.auliaridhov.moviecatalog.data.source.MovieDataSource;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.RemoteDataSource;
import com.auliaridhov.moviecatalog.utils.JsonHelper;

public class Injection {
    public static MovieRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return MovieRepository.getInstance(remoteDataSource);
    }
}
