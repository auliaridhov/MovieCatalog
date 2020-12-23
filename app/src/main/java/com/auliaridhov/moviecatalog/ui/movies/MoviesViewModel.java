package com.auliaridhov.moviecatalog.ui.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.MovieResponse;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.DataDummy;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private MutableLiveData<String> movieId = new MutableLiveData<>();
    private MutableLiveData<String> mLosin = new MutableLiveData<>();


    public MoviesViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public LiveData<Resource<List<MovieLocalEntity>>> movies = Transformations.switchMap(mLosin,
            data -> movieRepository.getAllMovie("movie"));

    public LiveData<List<MovieLocalEntity>> moviesFav = Transformations.switchMap(mLosin,
            data -> movieRepository.getFavoritedMovies());

    LiveData<Resource<MovieLocalEntity>> getMovieDetail = Transformations.switchMap(movieId,
            movieId -> movieRepository.getDetailMovie("movie", movieId));


    public void setUsername(String username) {
        mLosin.setValue(username);
    }

}
