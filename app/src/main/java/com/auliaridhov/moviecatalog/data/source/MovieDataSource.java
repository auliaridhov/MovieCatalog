package com.auliaridhov.moviecatalog.data.source;

import androidx.lifecycle.LiveData;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.List;

public interface MovieDataSource {


    LiveData<Resource<List<MovieLocalEntity>>> getAllMovie(String movie);

    LiveData<Resource<MovieLocalEntity>> getDetailMovie(String movie, String idMovie);

    LiveData<Resource<List<TvShowLocalEntity>>> getAllTv(String tv);

    LiveData<Resource<TvShowLocalEntity>> getDetailTv(String tv, String tdTv);

//    LiveData<Resource<PagedList<MovieLocalEntity>>> getAllFavoriteMoviesPaged();
//
//    LiveData<Resource<PagedList<TvShowLocalEntity>>> getAllFavoriteTvShowsPaged();

    void setMovieFavorited(MovieLocalEntity movie, boolean state);

    void setTvShowFavorited(TvShowLocalEntity tvshow, boolean state);

    LiveData<List<MovieLocalEntity>> getFavoritedMovies();

    LiveData<List<TvShowLocalEntity>> getFavoritedTv();


}
