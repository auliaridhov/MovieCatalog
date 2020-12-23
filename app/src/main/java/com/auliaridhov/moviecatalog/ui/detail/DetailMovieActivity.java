package com.auliaridhov.moviecatalog.ui.detail;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.data.source.local.entity.MovieLocalEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.EspressoIdlingResource;
import com.auliaridhov.moviecatalog.viewmodel.ViewModelFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;


public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_FROM = "movie_tv";
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";
    private TextView textTitle;
    private TextView textDesc;
    private TextView textDate;
    private TextView popularity;
    private ImageView imagePoster;
    private ProgressBar progressBar;
    private RelativeLayout relativeLayout;
    private ImageView imgFav;
    private DetailMovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        EspressoIdlingResource.increment();

        textTitle = findViewById(R.id.detailTitle);
        textDesc = findViewById(R.id.descDetail);
        textDate = findViewById(R.id.dateDetail);
        popularity = findViewById(R.id.popularity);
        imgFav = findViewById(R.id.imgFav);

        imagePoster = findViewById(R.id.ivPoster);

        relativeLayout = findViewById(R.id.layout_detail);
        progressBar = findViewById(R.id.progress_barr);

        relativeLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String courseId = extras.getString(EXTRA_MOVIE);
            String from = extras.getString(EXTRA_FROM);
            if (courseId != null) {
                if (from.equals("movie")){
                    viewModel.setMovieId(courseId);
                    viewModel.getMovieDetail.observe(this, movieDetail -> {
                        if (movieDetail != null) {

                            switch (movieDetail.status) {
                                case SUCCESS:
                                    if (movieDetail.data != null) {
                                        progressBar.setVisibility(View.GONE);
                                        populateMovie(movieDetail.data);
                                        setFavoritesMovie(movieDetail.data);
                                        break;
                                    }
                                case LOADING:
                                    progressBar.setVisibility(View.VISIBLE);
                                    break;
                                case ERROR:
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(DetailMovieActivity.this, "Ada Kesalahan Pada Aplikasi", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
//                    viewModel.setSelectedCourse(from, courseId);
//                    viewModel.getDetail().observe(this, this::populateTv);
                    viewModel.setTvId(courseId);
                    viewModel.getTvDetail.observe(this, movieDetail -> {
                        if (movieDetail != null) {

                            switch (movieDetail.status) {
                                case SUCCESS:
                                    if (movieDetail.data != null) {
                                        progressBar.setVisibility(View.GONE);
                                        populateTv(movieDetail.data);
                                        setFavoritesTv(movieDetail.data);
                                        break;
                                    }
                                case LOADING:
                                    progressBar.setVisibility(View.VISIBLE);
                                    break;
                                case ERROR:
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(DetailMovieActivity.this, "Ada Kesalahan Pada Aplikasi", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }


        }

    }

    private void populateMovie(MovieLocalEntity movies) {

        relativeLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        textTitle.setText(movies.getTitle());
        textDesc.setText(movies.getOverview());
        textDate.setText(movies.getReleaseDate());
        popularity.setText(String.valueOf(movies.getPopularity()));

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+movies.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);

        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
            EspressoIdlingResource.decrement();
        }
    }
    private void populateTv(TvShowLocalEntity movies) {

        relativeLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        textTitle.setText(movies.getOriginalName());
        textDesc.setText(movies.getOverview());
        textDate.setText(movies.getReleaseDate());
        popularity.setText(String.valueOf(movies.getPopularity()));

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+movies.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
            EspressoIdlingResource.decrement();
        }
    }

    private void setFavoritesTv(TvShowLocalEntity tvShowEntity) {
        if (tvShowEntity.isFavorited()) {
            imgFav.setImageResource(R.drawable.ic_baseline_favorite_24);
        }

        viewModel.getTvDetail.observe(this, tvShow -> {
            if (tvShow != null) {
                switch (tvShow.status) {
                    case SUCCESS:
                        if (tvShow.data != null) {
                            progressBar.setVisibility(View.GONE);
                            boolean state = tvShow.data.isFavorited();
                            imgFav.setOnClickListener(v -> {
                                if (state) {
                                    imgFav.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                                    Snackbar.make(imgFav, "Film Anda telah dihapus dari favorit", Snackbar.LENGTH_LONG).show();
                                    viewModel.setFavoriteTv();
                                } else {
                                    imgFav.setImageResource(R.drawable.ic_baseline_favorite_24);
                                    Snackbar.make(imgFav, "Film Anda telah ditambahkan ke favorit", Snackbar.LENGTH_LONG).show();
                                    viewModel.setFavoriteTv();
                                }
                            });
                        }
                        break;
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(DetailMovieActivity.this, "Ada Kesalahan Pada Aplikasi", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    private void setFavoritesMovie(MovieLocalEntity movieLocalEntity) {
        if (movieLocalEntity.isFavorited()) {
            imgFav.setImageResource(R.drawable.ic_baseline_favorite_24);
        }

        viewModel.getMovieDetail.observe(this, tvShow -> {
            if (tvShow != null) {
                switch (tvShow.status) {
                    case SUCCESS:
                        if (tvShow.data != null) {
                            progressBar.setVisibility(View.GONE);
                            boolean state = tvShow.data.isFavorited();
                            imgFav.setOnClickListener(v -> {
                                if (state) {
                                    imgFav.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                                    Snackbar.make(imgFav, "Film Anda telah dihapus dari favorit", Snackbar.LENGTH_LONG).show();
                                    viewModel.setFavoriteMovie();
                                } else {
                                    imgFav.setImageResource(R.drawable.ic_baseline_favorite_24);
                                    Snackbar.make(imgFav, "Film Anda telah ditambahkan ke favorit", Snackbar.LENGTH_LONG).show();
                                    viewModel.setFavoriteMovie();
                                }
                            });
                        }
                        break;
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(DetailMovieActivity.this, "Ada Kesalahan Pada Aplikasi", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}