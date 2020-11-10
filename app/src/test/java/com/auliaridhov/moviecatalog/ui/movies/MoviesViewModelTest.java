package com.auliaridhov.moviecatalog.ui.movies;

import com.auliaridhov.moviecatalog.data.MoviesEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MoviesViewModelTest {

    private MoviesViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new MoviesViewModel();
    }

    @Test
    public void getMovies() {
        List<MoviesEntity> courseEntities = viewModel.getMovies();
        assertNotNull(courseEntities);
        assertEquals(6, courseEntities.size());
    }
}