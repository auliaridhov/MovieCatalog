package com.auliaridhov.moviecatalog.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "movieentity")
public class MovieLocalEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "originalLanguage")
    private String originalLanguage;

    @ColumnInfo(name = "originalName")
    private String originalName;

    @ColumnInfo(name = "originalTitle")
    private String originalTitle;

    @ColumnInfo(name = "video")
    private boolean video;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "genreIds")
    private List<Integer> genreIds;

    @ColumnInfo(name = "posterPath")
    private String posterPath;

    @ColumnInfo(name = "backdropPath")
    private String backdropPath;

    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    @ColumnInfo(name = "mediaType")
    private String mediaType;

    @ColumnInfo(name = "voteAverage")
    private double voteAverage;

    @ColumnInfo(name = "popularity")
    private double popularity;

    @ColumnInfo(name = "adult")
    private boolean adult;

    @ColumnInfo(name = "voteCount")
    private int voteCount;
}
