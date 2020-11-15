package com.auliaridhov.moviecatalog.utils;

import android.content.Context;
import android.util.Log;

import com.auliaridhov.moviecatalog.data.source.remote.RemoteDataSource;
import com.auliaridhov.moviecatalog.data.source.remote.response.ApiConfig;
import com.auliaridhov.moviecatalog.data.source.remote.response.MovieResponse;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class JsonHelper {

    private Context context;
    List<ResultsItem> listMovie;
    ResultsItem resultsItem = null;

    public JsonHelper(Context ctx) {
        this.context = ctx;
    }

    public List<ResultsItem> loadMovies(String type) {
        Call<MovieResponse> client = ApiConfig.getApiService().getMovies(type);
        client.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        //callback.onAllMovieReceived(response.body().getResults());
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listMovie;
    }

    public ResultsItem loadDetail(String type, String id) {
        Call<ResultsItem> client = ApiConfig.getApiService().getDetail(type, id);
        client.enqueue(new Callback<ResultsItem>() {
            @Override
            public void onResponse(@NotNull Call<ResultsItem> call, @NotNull Response<ResultsItem> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                   //     callback.onDetailReceived(response.body());
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResultsItem> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
        return resultsItem;
    }

}
