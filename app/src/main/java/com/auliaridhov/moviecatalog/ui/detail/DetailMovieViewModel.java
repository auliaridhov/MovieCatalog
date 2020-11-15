package com.auliaridhov.moviecatalog.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import java.util.List;

public class DetailMovieViewModel extends ViewModel {
//    private String movieId;
//
//
//    public MoviesEntity getMovies() {
//        MoviesEntity movies = null;
//        List<MoviesEntity> moviesEntities = DataDummy.generateDummyMovies();
//        for (MoviesEntity moviesEntity : moviesEntities) {
//            if (moviesEntity.getIdMovies().equals(movieId)) {
//                movies = moviesEntity;
//            }
//        }
//        return movies;
//    }
//    public MoviesEntity getTV() {
//        MoviesEntity movies = null;
//        List<MoviesEntity> moviesEntities = DataDummy.generateDummyTvShow();
//        for (MoviesEntity moviesEntity : moviesEntities) {
//            if (moviesEntity.getIdMovies().equals(movieId)) {
//                movies = moviesEntity;
//            }
//        }
//        return movies;
//    }

    private String type;
    private String id;

    private MovieRepository movieRepository;
    public DetailMovieViewModel(MovieRepository mMovieRepository) {
        this.movieRepository = mMovieRepository;
    }

    public void setSelectedCourse(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public LiveData<ResultsItem> getDetail() {
        return movieRepository.getDetailTv(type, id);
    }



}
