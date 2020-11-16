package com.auliaridhov.moviecatalog.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DetailMovieViewModelTest {

    private DetailMovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private Observer<ResultsItem> observer;


//    private MoviesEntity dummyMovie = DataDummy.generateDummyMovies().get(0);
//    private MoviesEntity dummyTv = DataDummy.generateDummyTvShow().get(0);
//    private String idMovies = dummyMovie.getIdMovies();
//    private String idTv = dummyTv.getIdMovies();

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(movieRepository);
        viewModel.setSelectedCourse("movie", "");
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