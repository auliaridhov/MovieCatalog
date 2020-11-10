package com.auliaridhov.moviecatalog.ui.tvshow;

import androidx.lifecycle.ViewModel;

import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.utils.DataDummy;

import java.util.List;

public class TvshowViewModel extends ViewModel {
    public List<MoviesEntity> getTvShow() {
        return DataDummy.generateDummyTvShow();
    }
}
