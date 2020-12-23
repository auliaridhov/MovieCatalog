package com.auliaridhov.moviecatalog.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    LiveData<List<MovieLocalEntity>> getMovie();

    @Query("SELECT * FROM movie where favorited = 1")
    LiveData<List<MovieLocalEntity>> getFavorited();

    @Transaction
    @Query("SELECT * FROM movie WHERE id = :id")
    LiveData<MovieLocalEntity> getMovieById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(List<MovieLocalEntity> courses);

    @Update
    void updateMovie(MovieLocalEntity movieLocalEntity);




    @Query("SELECT * FROM tvshows")
    LiveData<List<TvShowLocalEntity>> getTvShow();

    @Query("SELECT * FROM tvshows where favorited = 1")
    LiveData<List<TvShowLocalEntity>> getTvShowFavorited();

    @Transaction
    @Query("SELECT * FROM tvshows WHERE id = :id")
    LiveData<TvShowLocalEntity> getTvShowById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShow(List<TvShowLocalEntity> courses);

    @Update
    void updateTvShow(TvShowLocalEntity tvShowLocalEntity);

//    @Query("SELECT * FROM movieentity WHERE id = :id")
//    LiveData<MovieLocalEntity> getModuleById(String id);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertModules(List<ModuleEntity> module);
//
//    @Update
//    void updateModule(ModuleEntity module);
//
//    @Query("UPDATE moduleentities SET content = :content WHERE moduleId = :moduleId")
//    void updateModuleByContent(String content, String moduleId);
}
