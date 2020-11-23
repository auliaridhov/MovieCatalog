package com.auliaridhov.moviecatalog.ui.detail;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailMovieViewModelTest {

    private DetailMovieViewModel viewModel;
    private ResultsItem dummyCourse = FakeDataDummy.generateDummyMovies().get(0);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private Observer<ResultsItem> observer;

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(movieRepository);
        viewModel.setSelectedCourse("movie", "524047");
    }

    @Test
    public void getDetail() {
        MutableLiveData<ResultsItem> course = new MutableLiveData<>();
        course.setValue(dummyCourse);
        when(movieRepository.getDetailTv("movie", "524047" )).thenReturn(course);
        viewModel.getDetail().observeForever(observer);
        verify(observer).onChanged(dummyCourse);
    }
}