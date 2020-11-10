package com.auliaridhov.moviecatalog.data;

public class MoviesEntity {

    private String idMovies;
    private String img;
    private String title;
    private String desc;
    private String popularity;
    private String date;

    public MoviesEntity(String idMovies, String img, String title, String desc, String popularity, String date) {
        this.idMovies = idMovies;
        this.img = img;
        this.title = title;
        this.desc = desc;
        this.popularity = popularity;
        this.date = date;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdMovies() {
        return idMovies;
    }

    public void setIdMovies(String idMovies) {
        this.idMovies = idMovies;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
