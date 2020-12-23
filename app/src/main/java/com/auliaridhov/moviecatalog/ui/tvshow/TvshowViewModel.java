package com.auliaridhov.moviecatalog.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.DataDummy;
import com.auliaridhov.moviecatalog.vo.Resource;

import java.util.List;

public class TvshowViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private MutableLiveData<String> tvId = new MutableLiveData<>();
    private MutableLiveData<String> mLosin = new MutableLiveData<>();

    public TvshowViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public LiveData<Resource<List<TvShowLocalEntity>>> tv = Transformations.switchMap(mLosin,
            data -> movieRepository.getAllTv("tv"));

    public LiveData<List<TvShowLocalEntity>> tvFav = Transformations.switchMap(mLosin,
            data -> movieRepository.getFavoritedTv());

    LiveData<Resource<TvShowLocalEntity>> getTvDetail = Transformations.switchMap(tvId,
            tvId -> movieRepository.getDetailTv("tv", tvId));


    public void setUsername(String username) {
        mLosin.setValue(username);
    }

}