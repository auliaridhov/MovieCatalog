package com.auliaridhov.moviecatalog.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.ui.movies.MoviesViewModel;
import com.auliaridhov.moviecatalog.ui.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvshowViewModelTest {

    private TvshowViewModel viewModel;
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private Observer<List<ResultsItem>> observer;

    @Before
    public void setUp() {
        viewModel = new TvshowViewModel(movieRepository);
    }

    @Test
    public void getTvShow() {
//        List<MoviesEntity> courseEntities = viewModel.getTvShow();
//        assertNotNull(courseEntities);
//        assertEquals(5, courseEntities.size());

//        MutableLiveData<List<ResultsItem>> courses = new MutableLiveData<>();
//        when(movieRepository.getAllMovie("movie")).thenReturn(courses);
//        List<ResultsItem> moviesEntities = viewModel.getTvShow().getValue();
//        verify(movieRepository).getAllMovie("movie");
//        assertNotNull(moviesEntities);
//        assertEquals(5, moviesEntities.size());

//        viewModel.getTvShow().observeForever(observer);
//===========================================================================================

        List<ResultsItem> resource = FakeDataDummy.generateDummyMovies();
        MutableLiveData<List<ResultsItem>> movies = new MutableLiveData<>();
        movies.setValue(resource);

        when(movieRepository.getAllTv("tv")).thenReturn(movies);
        //Observer<Resource<List<ResultsItem>>> observer = mock(Observer.class);
        viewModel.getTvShow().observeForever(observer);
        verify(observer).onChanged(resource);
    }
}