package com.auliaridhov.moviecatalog.ui.detail;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
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
    private DetailMovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        textTitle = findViewById(R.id.detailTitle);
        textDesc = findViewById(R.id.descDetail);
        textDate = findViewById(R.id.dateDetail);
        popularity = findViewById(R.id.popularity);

        imagePoster = findViewById(R.id.ivPoster);


        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String courseId = extras.getString(EXTRA_MOVIE);
            String from = extras.getString(EXTRA_FROM);
            if (courseId != null) {
                viewModel.setSelectedCourse(from, courseId);
                viewModel.getDetail().observe(this, this::populateCourse);

            }


        }

    }

    private void populateCourse(ResultsItem movies) {
        textTitle.setText(movies.getTitle());
        textDesc.setText(movies.getOverview());
        textDate.setText(movies.getReleaseDate());
        popularity.setText(String.valueOf(movies.getPopularity()));

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+movies.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
    }
}