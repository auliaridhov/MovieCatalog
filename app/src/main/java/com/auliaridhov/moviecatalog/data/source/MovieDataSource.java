package com.auliaridhov.moviecatalog.data.source;

import androidx.lifecycle.LiveData;

import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;

import java.util.List;

public interface MovieDataSource {

    LiveData<List<ResultsItem>> getAllMovie(String movie);

    LiveData<ResultsItem> getDetailMovie(String movie, String idMovie);

    LiveData<List<ResultsItem>> getAllTv(String tv);

    LiveData<ResultsItem> getDetailTv(String tv, String tdTv);

}
