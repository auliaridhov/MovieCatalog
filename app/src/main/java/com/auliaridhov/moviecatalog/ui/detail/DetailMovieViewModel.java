package com.auliaridhov.moviecatalog.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.DataDummy;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.List;

public class DetailMovieViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private MutableLiveData<String> movieId = new MutableLiveData<>();
    private MutableLiveData<String> tvId = new MutableLiveData<>();

    public DetailMovieViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    LiveData<Resource<MovieLocalEntity>> getMovieDetail = Transformations.switchMap(movieId,
            movieId -> movieRepository.getDetailMovie("movie", movieId));


    LiveData<Resource<TvShowLocalEntity>> getTvDetail = Transformations.switchMap(tvId,
            tvId -> movieRepository.getDetailTv("tv", tvId));


    void setMovieId(String movieId) {
        this.movieId.setValue(movieId);
    }
    void setTvId(String tvId) {
        this.tvId.setValue(tvId);
    }

    void setFavoriteMovie() {
        if (getMovieDetail.getValue() != null) {
            MovieLocalEntity movieEntity = getMovieDetail.getValue().data;

            if (movieEntity != null) {
                final boolean state = !movieEntity.isFavorited();
                movieRepository.setMovieFavorited(movieEntity, state);
            }
        }
    }

    void setFavoriteTv() {
        if (getTvDetail.getValue() != null) {
            TvShowLocalEntity tvShowLocalEntity = getTvDetail.getValue().data;

            if (tvShowLocalEntity != null) {
                final boolean state = !tvShowLocalEntity.isFavorited();
                movieRepository.setTvShowFavorited(tvShowLocalEntity, state);
            }
        }
    }

}
