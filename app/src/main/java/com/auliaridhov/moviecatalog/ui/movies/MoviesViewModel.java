package com.auliaridhov.moviecatalog.ui.movies;

import androidx.lifecycle.ViewModel;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    public List<MoviesEntity> getMovies() {
        return DataDummy.generateDummyMovies();
    }
}
