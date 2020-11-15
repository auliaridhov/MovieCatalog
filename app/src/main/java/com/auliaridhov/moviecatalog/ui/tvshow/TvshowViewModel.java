package com.auliaridhov.moviecatalog.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import java.util.List;

public class TvshowViewModel extends ViewModel {
    private MovieRepository movieRepository;

    public TvshowViewModel(MovieRepository mMovieRepository) {
        this.movieRepository = mMovieRepository;
    }

    public LiveData<List<ResultsItem>> getTvShow() {
        return movieRepository.getAllTv("tv");

    }
}
