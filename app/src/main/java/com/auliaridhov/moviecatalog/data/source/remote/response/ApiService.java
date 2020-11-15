package com.auliaridhov.moviecatalog.data.source.remote.response;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("trending/{type}/day?api_key=575fd5ed78ff0431fdabe8bd63eecaeb")
    Call<MovieResponse> getMovies(@Path("type") String type);

    @GET("{type}/{id}?api_key=575fd5ed78ff0431fdabe8bd63eecaeb&language=en-US")
    Call<ResultsItem> getDetail(@Path("type") String type, @Path("id") String id);
}