package com.auliaridhov.moviecatalog.ui.tvshow;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.ui.movies.MoviesViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvshowViewModelTest {

    private TvshowViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new TvshowViewModel();
    }

    @Test
    public void getTvShow() {
        List<MoviesEntity> courseEntities = viewModel.getTvShow();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}