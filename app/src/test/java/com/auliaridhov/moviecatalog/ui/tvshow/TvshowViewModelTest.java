package com.auliaridhov.moviecatalog.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;


import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.ui.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
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
        List<ResultsItem> resource = FakeDataDummy.generateDummyMovies();
        MutableLiveData<List<ResultsItem>> tv = new MutableLiveData<>();
        tv.setValue(resource);
        when(movieRepository.getAllTv("tv")).thenReturn(tv);
        viewModel.getTvShow().observeForever(observer);
        verify(observer).onChanged(resource);
    }
}