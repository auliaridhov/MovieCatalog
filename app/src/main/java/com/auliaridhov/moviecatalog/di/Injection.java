package com.auliaridhov.moviecatalog.di;

import android.content.Context;

import com.auliaridhov.moviecatalog.data.source.MovieDataSource;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.local.LocalDataSource;
import com.auliaridhov.moviecatalog.data.source.local.room.MovieDatabase;
import com.auliaridhov.moviecatalog.data.source.remote.RemoteDataSource;
import com.auliaridhov.moviecatalog.data.source.remote.response.ApiConfig;
import com.auliaridhov.moviecatalog.data.source.remote.response.ApiService;
import com.auliaridhov.moviecatalog.utils.AppExecutors;
import com.auliaridhov.moviecatalog.utils.JsonHelper;

public class Injection {
    public static MovieRepository provideRepository(Context context) {

        MovieDatabase database = MovieDatabase.getInstance(context);


        LocalDataSource localDataSource = LocalDataSource.getInstance(database.movieDao());
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(ApiConfig.getApiService());
        AppExecutors appExecutors = new AppExecutors();
        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors);
    }
}
