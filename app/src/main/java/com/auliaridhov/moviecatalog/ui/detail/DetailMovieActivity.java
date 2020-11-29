package com.auliaridhov.moviecatalog.ui.detail;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.utils.EspressoIdlingResource;
import com.auliaridhov.moviecatalog.viewmodel.ViewModelFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        EspressoIdlingResource.increment();

        textTitle = findViewById(R.id.detailTitle);
        textDesc = findViewById(R.id.descDetail);
        textDate = findViewById(R.id.dateDetail);
        popularity = findViewById(R.id.popularity);

        imagePoster = findViewById(R.id.ivPoster);

        relativeLayout = findViewById(R.id.layout_detail);
        progressBar = findViewById(R.id.progress_barr);

        relativeLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailMovieViewModel viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String courseId = extras.getString(EXTRA_MOVIE);
            String from = extras.getString(EXTRA_FROM);
            if (courseId != null) {
                if (from.equals("movie")){
                    viewModel.setSelectedCourse(from, courseId);
                    viewModel.getDetail().observe(this, this::populateMovie);
                } else {
                    viewModel.setSelectedCourse(from, courseId);
                    viewModel.getDetail().observe(this, this::populateTv);
                }


            }


        }

    }

    private void populateMovie(ResultsItem movies) {

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
    private void populateTv(ResultsItem movies) {

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
}