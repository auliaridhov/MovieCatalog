package com.auliaridhov.moviecatalog.ui.detail;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import java.util.List;

public class DetailMovieViewModel extends ViewModel {
    private String movieId;
    public void setSelectedCourse(String movieId) {
        this.movieId = movieId;
    }

    public MoviesEntity getMovies() {
        MoviesEntity movies = null;
        List<MoviesEntity> moviesEntities = DataDummy.generateDummyMovies();
        for (MoviesEntity moviesEntity : moviesEntities) {
            if (moviesEntity.getIdMovies().equals(movieId)) {
                movies = moviesEntity;
            }
        }
        return movies;
    }
    public MoviesEntity getTV() {
        MoviesEntity movies = null;
        List<MoviesEntity> moviesEntities = DataDummy.generateDummyTvShow();
        for (MoviesEntity moviesEntity : moviesEntities) {
            if (moviesEntity.getIdMovies().equals(movieId)) {
                movies = moviesEntity;
            }
        }
        return movies;
    }

}
