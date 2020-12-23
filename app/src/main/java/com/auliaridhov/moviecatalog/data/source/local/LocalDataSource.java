package com.auliaridhov.moviecatalog.data.source.local;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.room.MovieDao;

import java.util.List;

public class LocalDataSource {

    private static LocalDataSource INSTANCE;
    private final MovieDao mMovieDao;

    private LocalDataSource(MovieDao mMovieDao) {
        this.mMovieDao = mMovieDao;
    }

    public static LocalDataSource getInstance(MovieDao movieDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(movieDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieLocalEntity>> getAllMovie() {
        return mMovieDao.getMovie();
    }

//    public DataSource.Factory<Integer, MovieEntity> getFavMoviesPaged() {
//        return catalogDao.getFavMoviesAsPaged();
//    }

    public LiveData<List<MovieLocalEntity>> getFavoritedMovie() {
        return mMovieDao.getFavorited();
    }

    public LiveData<MovieLocalEntity> getMovieDetail(String id) {
        return mMovieDao.getMovieById(id);
    }

    public void insertMovies(List<MovieLocalEntity> movieEntities) {
        mMovieDao.insertMovie(movieEntities);
    }

    public void setMovieFavorite(MovieLocalEntity movieEntity, boolean state) {
        movieEntity.setFavorited(state);
        mMovieDao.updateMovie(movieEntity);

    }

    public LiveData<List<TvShowLocalEntity>> getAllTvShows() {
        return mMovieDao.getTvShow();
    }

//    public DataSource.Factory<Integer, TvShowEntity> getFavTvShowsPaged() {
//        return catalogDao.getFavTvShowAsPaged();
//    }

    public LiveData<List<TvShowLocalEntity>> getFavoritedTv() {
        return mMovieDao.getTvShowFavorited();
    }

    public LiveData<TvShowLocalEntity> getTvShowDetail(String id) {
        return mMovieDao.getTvShowById(id);
    }

    public void insertTvShow(List<TvShowLocalEntity> tvShowEntities) {
        mMovieDao.insertTvShow(tvShowEntities);
    }

    public void setTVFavorite(TvShowLocalEntity tvShowEntity, boolean state) {
        tvShowEntity.setFavorited(state);
        mMovieDao.updateTvShow(tvShowEntity);
    }
}