package com.auliaridhov.moviecatalog.data.source.local;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
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

    public LiveData<List<MovieLocalEntity>> getFavoritedMovie() {
        return mMovieDao.getFavorited();
    }
//
//    public LiveData<CourseWithModule> getCourseWithModules(final String courseId) {
//        return mAcademyDao.getCourseWithModuleById(courseId);
//    }

//    public LiveData<List<ModuleEntity>> getAllModulesByCourse(String courseId) {
//        return mAcademyDao.getModulesByCourseId(courseId);
//    }

    public void insertCourses(List<MovieLocalEntity> movies) {
        mMovieDao.insertMovie(movies);
    }

//    public void insertModules(List<MovieLocalEntity> movies) {
//        mMovieDao.insertModules(modules);
//    }

    public void setMovieFavorited(MovieLocalEntity movie, boolean newState) {
        movie.setFavorited(newState);
        mMovieDao.updateMovie(movie);
    }

//    public LiveData<ModuleEntity> getModuleWithContent(String moduleId) {
//        return mAcademyDao.getModuleById(moduleId);
//    }
//
//    public void updateContent(String content, String moduleId) {
//        mAcademyDao.updateModuleByContent(content, moduleId);
//    }
//
//    public void setReadModule(final ModuleEntity module) {
//        module.setRead(true);
//        mAcademyDao.updateModule(module);
//    }
}