package com.auliaridhov.moviecatalog.data.source.remote;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.auliaridhov.moviecatalog.data.source.remote.response.ApiConfig;
import com.auliaridhov.moviecatalog.data.source.remote.response.MovieResponse;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.EspressoIdlingResource;
import com.auliaridhov.moviecatalog.utils.JsonHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler();
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private List<ResultsItem> _listMovies = new ArrayList<ResultsItem>();
    private List<ResultsItem> _listMoviesTv = new ArrayList<ResultsItem>();
    private ResultsItem _detail = null;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public void getList(String type, LoadMovieCallback callback) {
        EspressoIdlingResource.increment();
        Call<MovieResponse> client = ApiConfig.getApiService().getMovies(type);
        client.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        _listMovies = response.body().getResults();
                        EspressoIdlingResource.decrement();
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
        handler.postDelayed(()-> callback.onAllMovieReceived(_listMovies), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getListTv(String type, LoadTvCallback callback) {
        EspressoIdlingResource.increment();
        Call<MovieResponse> client = ApiConfig.getApiService().getMovies(type);
        client.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        _listMoviesTv = response.body().getResults();
                        EspressoIdlingResource.decrement();
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
        handler.postDelayed(()-> callback.onAllTvReceived(_listMoviesTv), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getDetail(String type, String id, LoadDetailCallback callback) {
        EspressoIdlingResource.increment();
        Call<ResultsItem> client = ApiConfig.getApiService().getDetail(type, id);
        client.enqueue(new Callback<ResultsItem>() {
            @Override
            public void onResponse(@NotNull Call<ResultsItem> call, @NotNull Response<ResultsItem> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        _detail = response.body();
                        EspressoIdlingResource.decrement();
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
        handler.postDelayed(()-> callback.onDetailReceived(_detail), SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMovieCallback {
        void onAllMovieReceived(List<ResultsItem> resultsItemList);
    }
    public interface LoadTvCallback {
        void onAllTvReceived(List<ResultsItem> resultsItemList);
    }
    public interface LoadDetailCallback {
        void onDetailReceived(ResultsItem resultsItem);
    }

}
