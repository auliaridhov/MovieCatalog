package com.auliaridhov.moviecatalog.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.auliaridhov.moviecatalog.data.NetworkBoundResource;
import com.auliaridhov.moviecatalog.data.source.local.LocalDataSource;
import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.ApiResponse;
import com.auliaridhov.moviecatalog.data.source.remote.RemoteDataSource;
import com.auliaridhov.moviecatalog.data.source.remote.response.MovieResponse;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.AppExecutors;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository
        //implements MovieDataSource
{
//
//    private volatile static MovieRepository INSTANCE = null;
//    private final RemoteDataSource remoteDataSource;
//    private final LocalDataSource localDataSource;
//    private final AppExecutors appExecutors;
//
//    private MovieRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
//        this.remoteDataSource = remoteDataSource;
//        this.localDataSource = localDataSource;
//        this.appExecutors = appExecutors;
//    }
//    public static MovieRepository getInstance(RemoteDataSource remoteData, LocalDataSource localDataSource, AppExecutors appExecutors) {
//        if (INSTANCE == null) {
//            synchronized (MovieRepository.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new MovieRepository(remoteData, localDataSource, appExecutors);
//                }
//            }
//        }
//        return INSTANCE;
//    }
//    @Override
//    public LiveData<Resource<List<ResultsItem>>>  getAllMovie(String movie) {
//        return new NetworkBoundResource<List<MovieLocalEntity>, List<MovieResponse>>(appExecutors) {
//            @Override
//            public LiveData<List<MovieLocalEntity>> loadFromDB() {
//                return localDataSource.getAllMovie();
//            }
//            @Override
//            public Boolean shouldFetch(List<MovieLocalEntity> data) {
//                return (data == null) || (data.size() == 0);
//            }
//            @Override
//            public LiveData<ApiResponse<List<MovieResponse>>> createCall() {
//                return remoteDataSource.getList(movie);
//            }
//            @Override
//            public void saveCallResult(List<MovieLocalEntity> courseResponses) {
//                ArrayList<MovieLocalEntity> courseList = new ArrayList<>();
//                for (MovieLocalEntity response : courseResponses) {
//                    MovieLocalEntity course = new MovieLocalEntity(
//                            response.getId(),
//                            response.getOverview(),
//                            response.getOriginalLanguage(),
//                            response.getOriginalName(),
//                            response.getOriginalTitle(),
//                            false,
//                    response.getTitle(),
//                    response.getGenreIds(),
//                    response.getPosterPath(),
//                    response.getBackdropPath(),
//                    response.getReleaseDate(),
//                    response.getMediaType(),
//                    response.getVoteAverage(),
//                    response.getPopularity(),
//                    response.isAdult(),
//                    response.getVoteCount(),
//                    false
//                    );
//
//                    courseList.add(course);
//                }
//
//                localDataSource.insertCourses(courseList);
//            }
//        }.asLiveData();
//    }
//    @Override
//    public LiveData<ResultsItem> getDetailMovie(String movie, String idMovie) {
//        MutableLiveData<ResultsItem> moduleResult = new MutableLiveData<>();
//        remoteDataSource.getDetail(movie, idMovie, moduleResponses -> {
//            ResultsItem resultsItem;
//            resultsItem = new ResultsItem(moduleResponses.getOverview(),
//                    moduleResponses.getOriginalLanguage(),
//                    moduleResponses.getOriginalTitle(),
//                    moduleResponses.isVideo(),
//                    moduleResponses.getTitle(),
//                    moduleResponses.getGenreIds(),
//                    moduleResponses.getPosterPath(),
//                    moduleResponses.getBackdropPath(),
//                    moduleResponses.getReleaseDate(),
//                    moduleResponses.getMediaType(),
//                    moduleResponses.getVoteAverage(),
//                    moduleResponses.getPopularity(),
//                    moduleResponses.getId(),
//                    moduleResponses.isAdult(),
//                    moduleResponses.getVoteCount(),
//                    moduleResponses.getOriginalName());
//
//            moduleResult.postValue(resultsItem);
//        });
//        return moduleResult;
//    }
//    @Override
//    public LiveData<List<ResultsItem>> getAllTv(String tv) {
//        MutableLiveData<List<ResultsItem>> courseResults = new MutableLiveData<>();
//        remoteDataSource.getListTv(tv, movieResponses -> {
//            ArrayList<ResultsItem> courseList = new ArrayList<>();
//            for (ResultsItem response : movieResponses) {
//                ResultsItem course = new ResultsItem(response.getOverview(),
//                        response.getOriginalLanguage(),
//                        response.getOriginalTitle(),
//                        response.isVideo(),
//                        response.getTitle(),
//                        response.getGenreIds(),
//                        response.getPosterPath(),
//                        response.getBackdropPath(),
//                        response.getReleaseDate(),
//                        response.getMediaType(),
//                        response.getVoteAverage(),
//                        response.getPopularity(),
//                        response.getId(),
//                        response.isAdult(),
//                        response.getVoteCount(),
//                        response.getOriginalName());
//
//                courseList.add(course);
//            }
//            courseResults.postValue(courseList);
//        });
//        return courseResults;
//    }
//
//    @Override
//    public LiveData<ResultsItem> getDetailTv(String movie, String idMovie) {
//        MutableLiveData<ResultsItem> moduleResult = new MutableLiveData<>();
//        remoteDataSource.getDetail(movie, idMovie, moduleResponses -> {
//            ResultsItem resultsItem;
//            resultsItem = new ResultsItem(moduleResponses.getOverview(),
//                    moduleResponses.getOriginalLanguage(),
//                    moduleResponses.getOriginalTitle(),
//                    moduleResponses.isVideo(),
//                    moduleResponses.getTitle(),
//                    moduleResponses.getGenreIds(),
//                    moduleResponses.getPosterPath(),
//                    moduleResponses.getBackdropPath(),
//                    moduleResponses.getReleaseDate(),
//                    moduleResponses.getMediaType(),
//                    moduleResponses.getVoteAverage(),
//                    moduleResponses.getPopularity(),
//                    moduleResponses.getId(),
//                    moduleResponses.isAdult(),
//                    moduleResponses.getVoteCount(),
//                    moduleResponses.getOriginalName());
//
//            moduleResult.postValue(resultsItem);
//        });
//        return moduleResult;
//    }
//
//    @Override
//    public void setMovieBookmarked(MovieLocalEntity course, boolean state) {
//
//    }
}
