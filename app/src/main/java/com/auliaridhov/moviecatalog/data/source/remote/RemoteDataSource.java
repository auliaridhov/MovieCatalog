package com.auliaridhov.moviecatalog.data.source.remote;

import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.auliaridhov.moviecatalog.data.source.remote.response.ApiConfig;
import com.auliaridhov.moviecatalog.data.source.remote.response.ApiService;
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
    private ApiService apiService;
    private Handler handler = new Handler();
    private final long SERVICE_LATENCY_IN_MILLIS = 3000;
    private List<ResultsItem> _listMovies = new ArrayList<ResultsItem>();
    private List<ResultsItem> _listMoviesTv = new ArrayList<ResultsItem>();
    private ResultsItem _detail = null;

    private RemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    public static RemoteDataSource getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(apiService);
        }
        return INSTANCE;
    }


    public LiveData<ApiResponse<List<ResultsItem>>> getList(String type) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<ResultsItem>>> resultMovies = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<MovieResponse> call = ApiConfig.getApiService().getMovies(type);
            //Call<MovieResponse> call = apiService.getMovies(BuildConfig.TMDB_API_KEY, LANGUAGE);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                    if (response.body() != null) {
                        resultMovies.setValue(ApiResponse.success(response.body().getResults()));
                        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                            EspressoIdlingResource.decrement();
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                    EspressoIdlingResource.decrement();
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);

        return resultMovies;
    }

    public LiveData<ApiResponse<List<ResultsItem>>> getListTv(String type) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<ResultsItem>>> resultMovies = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<MovieResponse> call = ApiConfig.getApiService().getMovies(type);
            //Call<MovieResponse> call = apiService.getMovies(BuildConfig.TMDB_API_KEY, LANGUAGE);
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                    if (response.body() != null) {
                        resultMovies.setValue(ApiResponse.success(response.body().getResults()));
                        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                            EspressoIdlingResource.decrement();
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                    EspressoIdlingResource.decrement();
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);

        return resultMovies;
    }


    public LiveData<ApiResponse<ResultsItem>> getDetailMovie(String type, String id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<ResultsItem>> resultMovie = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<ResultsItem> call = ApiConfig.getApiService().getDetail(type, id);
            call.enqueue(new Callback<ResultsItem>() {
                @Override
                public void onResponse(@NotNull Call<ResultsItem> call, @NotNull Response<ResultsItem> response) {
                    resultMovie.setValue(ApiResponse.success(response.body()));
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                        EspressoIdlingResource.decrement();
                    }
                }

                @Override
                public void onFailure(@NotNull Call<ResultsItem> call, @NotNull Throwable t) {
                    EspressoIdlingResource.decrement();
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovie;
    }

    public LiveData<ApiResponse<ResultsItem>> getDetailTv(String type, String id) {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<ResultsItem>> resultMovie = new MutableLiveData<>();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Call<ResultsItem> call = ApiConfig.getApiService().getDetail(type, id);
            call.enqueue(new Callback<ResultsItem>() {
                @Override
                public void onResponse(@NotNull Call<ResultsItem> call, @NotNull Response<ResultsItem> response) {
                    resultMovie.setValue(ApiResponse.success(response.body()));
                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                        EspressoIdlingResource.decrement();
                    }
                }

                @Override
                public void onFailure(@NotNull Call<ResultsItem> call, @NotNull Throwable t) {
                    EspressoIdlingResource.decrement();
                }
            });

        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovie;
    }

}
