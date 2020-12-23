package com.auliaridhov.moviecatalog.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;

import java.util.List;

public interface MovieDao {

    @Query("SELECT * FROM movieentity")
    LiveData<List<MovieLocalEntity>> getMovie();

    @Query("SELECT * FROM movieentity where favorited = 1")
    LiveData<List<MovieLocalEntity>> getFavorited();

    @Transaction
    @Query("SELECT * FROM movieentity WHERE id = :id")
    LiveData<MovieLocalEntity> getMovieById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(List<MovieLocalEntity> courses);

    @Update
    void updateMovie(MovieLocalEntity movieLocalEntity);

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
