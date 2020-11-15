package com.auliaridhov.moviecatalog.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.auliaridhov.moviecatalog.data.source.remote.RemoteDataSource;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements MovieDataSource {

    private volatile static MovieRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    private MovieRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static MovieRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (MovieRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<ResultsItem>> getAllMovie(String movie) {
        //return remoteDataSource.getList();
        MutableLiveData<List<ResultsItem>> courseResults = new MutableLiveData<>();
        remoteDataSource.getList(movie, movieResponses -> {
            ArrayList<ResultsItem> courseList = new ArrayList<>();
            for (ResultsItem response : movieResponses) {
                ResultsItem course = new ResultsItem(response.getOverview(),
                        response.getOriginalLanguage(),
                        response.getOriginalTitle(),
                        response.isVideo(),
                        response.getTitle(),
                        response.getGenreIds(),
                        response.getPosterPath(),
                        response.getBackdropPath(),
                        response.getReleaseDate(),
                        response.getMediaType(),
                        response.getVoteAverage(),
                        response.getPopularity(),
                        response.getId(),
                        response.isAdult(),
                        response.getVoteCount(),
                        response.getOriginalName());

                courseList.add(course);
            }
            courseResults.postValue(courseList);
        });
        return courseResults;
    }

    @Override
    public LiveData<ResultsItem> getDetailMovie(String movie, String idMovie) {
        MutableLiveData<ResultsItem> moduleResult = new MutableLiveData<>();
        remoteDataSource.getDetail(movie, idMovie, moduleResponses -> {
            remoteDataSource.getDetail(movie, idMovie, moduleResult::postValue);
        });
        return moduleResult;
    }

    @Override
    public LiveData<List<ResultsItem>> getAllTv(String tv) {
        //return remoteDataSource.getList();
        MutableLiveData<List<ResultsItem>> courseResults = new MutableLiveData<>();
        remoteDataSource.getListTv(tv, movieResponses -> {
            ArrayList<ResultsItem> courseList = new ArrayList<>();
            for (ResultsItem response : movieResponses) {
                ResultsItem course = new ResultsItem(response.getOverview(),
                        response.getOriginalLanguage(),
                        response.getOriginalTitle(),
                        response.isVideo(),
                        response.getTitle(),
                        response.getGenreIds(),
                        response.getPosterPath(),
                        response.getBackdropPath(),
                        response.getReleaseDate(),
                        response.getMediaType(),
                        response.getVoteAverage(),
                        response.getPopularity(),
                        response.getId(),
                        response.isAdult(),
                        response.getVoteCount(),
                        response.getOriginalName());

                courseList.add(course);
            }
            courseResults.postValue(courseList);
        });
        return courseResults;
    }

    @Override
    public LiveData<ResultsItem> getDetailTv(String movie, String idMovie) {
        MutableLiveData<ResultsItem> moduleResult = new MutableLiveData<>();
        remoteDataSource.getDetail(movie, idMovie, moduleResponses -> {
            ResultsItem resultsItem;

            resultsItem = new ResultsItem(moduleResponses.getOverview(),
                    moduleResponses.getOriginalLanguage(),
                    moduleResponses.getOriginalTitle(),
                    moduleResponses.isVideo(),
                    moduleResponses.getTitle(),
                    moduleResponses.getGenreIds(),
                    moduleResponses.getPosterPath(),
                    moduleResponses.getBackdropPath(),
                    moduleResponses.getReleaseDate(),
                    moduleResponses.getMediaType(),
                    moduleResponses.getVoteAverage(),
                    moduleResponses.getPopularity(),
                    moduleResponses.getId(),
                    moduleResponses.isAdult(),
                    moduleResponses.getVoteCount(),
                    moduleResponses.getOriginalName());

            moduleResult.postValue(resultsItem);
        });
        return moduleResult;
    }
}
