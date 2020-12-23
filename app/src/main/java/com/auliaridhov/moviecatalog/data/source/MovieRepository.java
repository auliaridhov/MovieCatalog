package com.auliaridhov.moviecatalog.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.auliaridhov.moviecatalog.data.NetworkBoundResource;
import com.auliaridhov.moviecatalog.data.source.local.LocalDataSource;
import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.ApiResponse;
import com.auliaridhov.moviecatalog.data.source.remote.RemoteDataSource;
import com.auliaridhov.moviecatalog.data.source.remote.response.MovieResponse;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.AppExecutors;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements MovieDataSource{


    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;
    private volatile static MovieRepository INSTANCE = null;


    private MovieRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }
    public static MovieRepository getInstance(RemoteDataSource remoteData, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MovieRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieRepository(remoteData, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MovieLocalEntity>>> getAllMovie(String type) {
        return new NetworkBoundResource<List<MovieLocalEntity>, List<ResultsItem>>(appExecutors) {

            @Override
            protected LiveData<List<MovieLocalEntity>> loadFromDB() {
                return localDataSource.getAllMovie();
            }

            @Override
            protected Boolean shouldFetch(List<MovieLocalEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<ResultsItem>>> createCall() {
                return remoteDataSource.getList(type);
            }

            @Override
            protected void saveCallResult(List<ResultsItem> data) {
                List<MovieLocalEntity> movieEntities = new ArrayList<>();

                for (ResultsItem movie : data) {
                    movieEntities.add(new MovieLocalEntity(
                            movie.getId(),
                            movie.getOverview(),
                            movie.getOriginalLanguage(),
                            movie.getOriginalName(),
                            movie.getOriginalTitle(),
                            movie.isVideo(),
                            movie.getTitle(),

                            movie.getPosterPath(),
                            movie.getBackdropPath(),
                            movie.getReleaseDate(),
                            movie.getMediaType(),
                            movie.getVoteAverage(),
                            movie.getPopularity(),
                            movie.isAdult(),
                            movie.getVoteCount(),
                            null));

                }
                localDataSource.insertMovies(movieEntities);

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShowLocalEntity>>> getAllTv(String type) {
        return new NetworkBoundResource<List<TvShowLocalEntity>, List<ResultsItem>>(appExecutors) {

            @Override
            protected LiveData<List<TvShowLocalEntity>> loadFromDB() {
                return localDataSource.getAllTvShows();
            }

            @Override
            protected Boolean shouldFetch(List<TvShowLocalEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<ResultsItem>>> createCall() {
                return remoteDataSource.getListTv(type);
            }

            @Override
            protected void saveCallResult(List<ResultsItem> data) {
                List<TvShowLocalEntity> movieEntities = new ArrayList<>();

                for (ResultsItem movie : data) {
                    movieEntities.add(new TvShowLocalEntity(
                            movie.getId(),
                            movie.getOverview(),
                            movie.getOriginalLanguage(),
                            movie.getOriginalName(),
                            movie.getOriginalTitle(),
                            movie.isVideo(),
                            movie.getTitle(),

                            movie.getPosterPath(),
                            movie.getBackdropPath(),
                            movie.getReleaseDate(),
                            movie.getMediaType(),
                            movie.getVoteAverage(),
                            movie.getPopularity(),
                            movie.isAdult(),
                            movie.getVoteCount(),
                            null));

                }
                localDataSource.insertTvShow(movieEntities);

            }
        }.asLiveData();
    }



    @Override
    public LiveData<Resource<MovieLocalEntity>> getDetailMovie(String movie, String idMovie) {
        return new NetworkBoundResource<MovieLocalEntity, ResultsItem>(appExecutors) {

            @Override
            protected LiveData<MovieLocalEntity> loadFromDB() {
                return localDataSource.getMovieDetail(idMovie);
            }

            @Override
            protected Boolean shouldFetch(MovieLocalEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<ResultsItem>> createCall() {
                return remoteDataSource.getDetailMovie(movie, idMovie);
            }

            @Override
            protected void saveCallResult(ResultsItem movie) {
                MovieLocalEntity movieEntity = new MovieLocalEntity(
                        movie.getId(),
                        movie.getOverview(),
                        movie.getOriginalLanguage(),
                        movie.getOriginalName(),
                        movie.getOriginalTitle(),
                        movie.isVideo(),
                        movie.getTitle(),

                        movie.getPosterPath(),
                        movie.getBackdropPath(),
                        movie.getReleaseDate(),
                        movie.getMediaType(),
                        movie.getVoteAverage(),
                        movie.getPopularity(),
                        movie.isAdult(),
                        movie.getVoteCount(),
                        null);
                List<MovieLocalEntity> movieEntities = new ArrayList<>();
                movieEntities.add(movieEntity);
                localDataSource.insertMovies(movieEntities);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowLocalEntity>> getDetailTv(String tv, String tdTv) {
        return new NetworkBoundResource<TvShowLocalEntity, ResultsItem>(appExecutors) {

            @Override
            protected LiveData<TvShowLocalEntity> loadFromDB() {
                return localDataSource.getTvShowDetail(tdTv);
            }

            @Override
            protected Boolean shouldFetch(TvShowLocalEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<ResultsItem>> createCall() {
                return remoteDataSource.getDetailTv(tv, tdTv);
            }

            @Override
            protected void saveCallResult(ResultsItem movie) {
                TvShowLocalEntity movieEntity = new TvShowLocalEntity(
                        movie.getId(),
                        movie.getOverview(),
                        movie.getOriginalLanguage(),
                        movie.getOriginalName(),
                        movie.getOriginalTitle(),
                        movie.isVideo(),
                        movie.getTitle(),
                        movie.getPosterPath(),
                        movie.getBackdropPath(),
                        movie.getReleaseDate(),
                        movie.getMediaType(),
                        movie.getVoteAverage(),
                        movie.getPopularity(),
                        movie.isAdult(),
                        movie.getVoteCount(),
                        null);
                List<TvShowLocalEntity> movieEntities = new ArrayList<>();
                movieEntities.add(movieEntity);
                localDataSource.insertTvShow(movieEntities);
            }
        }.asLiveData();
    }


    @Override
    public void setMovieFavorited(MovieLocalEntity movie, boolean state) {
        Runnable runnable = () -> localDataSource.setMovieFavorite(movie, state);
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void setTvShowFavorited(TvShowLocalEntity tvshow, boolean state) {
        Runnable runnable = () -> localDataSource.setTVFavorite(tvshow, state);
        appExecutors.diskIO().execute(runnable);

    }

    @Override
    public LiveData<List<MovieLocalEntity>> getFavoritedMovies() {
        return localDataSource.getFavoritedMovie();
    }

    @Override
    public LiveData<List<TvShowLocalEntity>> getFavoritedTv() {
        return localDataSource.getFavoritedTv();
    }


}
