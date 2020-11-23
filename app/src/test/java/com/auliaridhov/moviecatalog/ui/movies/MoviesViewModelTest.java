package com.auliaridhov.moviecatalog.ui.movies;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.ui.utils.FakeDataDummy;
import com.bumptech.glide.load.engine.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
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
        List<ResultsItem> resource = FakeDataDummy.generateDummyMovies();
        MutableLiveData<List<ResultsItem>> movies = new MutableLiveData<>();
        movies.setValue(resource);
        when(movieRepository.getAllMovie("movie")).thenReturn(movies);
        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(resource);

    }
}