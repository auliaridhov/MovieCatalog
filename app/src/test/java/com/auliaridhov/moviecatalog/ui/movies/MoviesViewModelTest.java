package com.auliaridhov.moviecatalog.ui.movies;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
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

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoviesViewModelTest {

    private MoviesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private Observer<List<ResultsItem>> observer;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel(movieRepository);
    }

    @Test
    public void getMovies() {
//        List<ResultsItem> courseEntities = viewModel.getMovies();
//        assertNotNull(courseEntities);
//        assertEquals(6, courseEntities.size());



        MutableLiveData<List<ResultsItem>> courses = new MutableLiveData<>();
        when(movieRepository.getAllMovie("movie")).thenReturn(courses);
        List<ResultsItem> moviesEntities = viewModel.getMovies().getValue();
        verify(movieRepository).getAllMovie("movie");
        assertNotNull(moviesEntities);
        assertEquals(5, moviesEntities.size());

        viewModel.getMovies().observeForever(observer);
//        verify(observer).onChanged(dummyCourses);

    }
}