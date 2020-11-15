package com.auliaridhov.moviecatalog.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.auliaridhov.moviecatalog.data.source.MovieRepository;
import com.auliaridhov.moviecatalog.di.Injection;
import com.auliaridhov.moviecatalog.ui.detail.DetailMovieViewModel;
import com.auliaridhov.moviecatalog.ui.movies.MoviesViewModel;
import com.auliaridhov.moviecatalog.ui.tvshow.TvshowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieRepository mMovieRepository;

    private ViewModelFactory(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
            return (T) new MoviesViewModel(mMovieRepository);
        } else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            return (T) new DetailMovieViewModel(mMovieRepository);
        } else if (modelClass.isAssignableFrom(TvshowViewModel.class)) {
            return (T) new TvshowViewModel(mMovieRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
