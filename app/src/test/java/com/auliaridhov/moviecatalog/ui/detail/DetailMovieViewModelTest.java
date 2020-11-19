package com.auliaridhov.moviecatalog.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailMovieViewModel viewModel;

    private ResultsItem dummyDetail = FakeDataDummy.generateDummyMovies().get(0);
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
    }


    @Test
    public void getMovies() {
        MutableLiveData<ResultsItem> course = new MutableLiveData<>();
        viewModel.setSelectedCourse("movie", "524047");
        ResultsItem resultsItem = viewModel.getDetail().getValue();
        assertNotNull(resultsItem);
        assertEquals("Greenland", resultsItem.getOriginalTitle());
        assertEquals(String.valueOf(172.638), String.valueOf(resultsItem.getPopularity()));
        assertEquals("/bNo2mcvSwIvnx8K6y1euAc1TLVq.jpg", resultsItem.getPosterPath());

        course.setValue(resultsItem);
        when(movieRepository.getDetailMovie("movie", "524047" )).thenReturn(course);
        viewModel.getDetail().observeForever(observer);
        verify(observer).onChanged(resultsItem);


//        MutableLiveData<ResultsItem> tvShowMutableLiveData = new MutableLiveData<>();
//        tvShowMutableLiveData.setValue(dummyDetail);
//
//        if (dummyDetail != null) {
//            when(movieRepository.getDetailMovie("movie",String.valueOf(dummyDetail.getId()))).thenReturn(tvShowMutableLiveData);
//        }
//        viewModel.getDetail().observeForever(observer);
//        verify(observer).onChanged(dummyDetail);
    }


    @Test
    public void getTV() {
        MutableLiveData<ResultsItem> course = new MutableLiveData<>();
        viewModel.setSelectedCourse("tv", "65494");
        ResultsItem resultsItem = viewModel.getDetail().getValue();
//        assertNotNull(resultsItem);
//        assertEquals("Greenland", resultsItem.getOriginalTitle());
//        assertEquals(String.valueOf(172.638), String.valueOf(resultsItem.getPopularity()));
//        assertEquals("/bNo2mcvSwIvnx8K6y1euAc1TLVq.jpg", resultsItem.getPosterPath());
//        course.setValue(resultsItem);
        when(movieRepository.getDetailMovie("movie", "524047" )).thenReturn(course);
        viewModel.getDetail().observeForever(observer);
        verify(observer).onChanged(resultsItem);

//        MutableLiveData<ResultsItem> tvShowMutableLiveData = new MutableLiveData<>();
//        tvShowMutableLiveData.setValue(dummyDetail);
//
//        if (dummyDetail != null) {
//            when(movieRepository.getDetailMovie("tv",String.valueOf(dummyDetail.getId()))).thenReturn(tvShowMutableLiveData);
//        }
//        viewModel.getDetail().observeForever(observer);
//        verify(observer).onChanged(dummyDetail);
    }

}