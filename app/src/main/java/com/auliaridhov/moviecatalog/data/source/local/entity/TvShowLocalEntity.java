package com.auliaridhov.moviecatalog.data.source.local.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tvshows")
public class TvShowLocalEntity {

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

    @ColumnInfo(name = "favorited")
    private boolean favorited;

    public TvShowLocalEntity(int id, String overview, String originalLanguage, String originalName, String originalTitle, boolean video, String title, String posterPath, String backdropPath, String releaseDate, String mediaType, double voteAverage, double popularity, boolean adult, int voteCount, Boolean favorited) {
        this.id = id;
        this.overview = overview;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.originalTitle = originalTitle;
        this.video = video;
        this.title = title;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.mediaType = mediaType;
        this.voteAverage = voteAverage;
        this.popularity = popularity;
        this.adult = adult;
        this.voteCount = voteCount;
        if (favorited != null) {
            this.favorited = favorited;
        }
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}

