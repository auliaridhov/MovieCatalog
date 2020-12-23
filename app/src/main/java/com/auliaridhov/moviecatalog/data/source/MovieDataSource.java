package com.auliaridhov.moviecatalog.data.source;

import androidx.lifecycle.LiveData;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.List;

public interface MovieDataSource {

//    LiveData<List<ResultsItem>> getAllMovie(String movie);
//
//    LiveData<ResultsItem> getDetailMovie(String movie, String idMovie);
//
//    LiveData<List<ResultsItem>> getAllTv(String tv);
//
//    LiveData<ResultsItem> getDetailTv(String tv, String tdTv);

    LiveData<Resource<List<ResultsItem>>> getAllMovie(String movie);

    LiveData<Resource<ResultsItem>> getDetailMovie(String movie, String idMovie);

    LiveData<Resource<List<ResultsItem>>> getAllTv(String tv);

    LiveData<Resource<ResultsItem>> getDetailTv(String tv, String tdTv);

//    LiveData<Resource<List<ModuleEntity>>> getAllModulesByCourse(String courseId);
//
//    LiveData<Resource<ModuleEntity>> getContent(String moduleId);
//
//    LiveData<List<CourseEntity>> getBookmarkedCourses();

    void setMovieBookmarked(MovieLocalEntity course, boolean state);
    //void setReadModule(ModuleEntity module);

}
