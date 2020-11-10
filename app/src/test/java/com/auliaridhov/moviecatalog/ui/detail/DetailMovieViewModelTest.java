package com.auliaridhov.moviecatalog.ui.detail;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {

    private DetailMovieViewModel viewModel;
    private MoviesEntity dummyMovie = DataDummy.generateDummyMovies().get(0);
    private MoviesEntity dummyTv = DataDummy.generateDummyTvShow().get(0);
    private String idMovies = dummyMovie.getIdMovies();
    private String idTv = dummyTv.getIdMovies();

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel();
        viewModel.setSelectedCourse(idMovies);
    }

    @Test
    public void getMovies() {
        viewModel.setSelectedCourse(dummyMovie.getIdMovies());
        MoviesEntity moviesEntity = viewModel.getMovies();
        assertNotNull(moviesEntity);
        assertEquals(dummyMovie.getIdMovies(), moviesEntity.getIdMovies());
        assertEquals(dummyMovie.getPopularity(), moviesEntity.getPopularity());
        assertEquals(dummyMovie.getDate(), moviesEntity.getDate());
        assertEquals(dummyMovie.getImg(), moviesEntity.getImg());
        assertEquals(dummyMovie.getTitle(), moviesEntity.getTitle());
    }

    @Test
    public void getTV() {
        viewModel.setSelectedCourse(dummyTv.getIdMovies());
        MoviesEntity moviesEntity = viewModel.getTV();
        assertNotNull(moviesEntity);
        assertEquals(dummyTv.getIdMovies(), moviesEntity.getIdMovies());
        assertEquals(dummyTv.getPopularity(), moviesEntity.getPopularity());
        assertEquals(dummyTv.getDate(), moviesEntity.getDate());
        assertEquals(dummyTv.getImg(), moviesEntity.getImg());
        assertEquals(dummyTv.getTitle(), moviesEntity.getTitle());
    }

}