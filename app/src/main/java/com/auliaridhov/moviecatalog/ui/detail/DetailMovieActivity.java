package com.auliaridhov.moviecatalog.ui.detail;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class DetailMovieActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDesc;
    private TextView textDate;
    private TextView popularity;
    private ImageView imagePoster;
    private DetailMovieViewModel viewModel;

    public static final String EXTRA_FROM = "movie_tv";
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        textTitle = findViewById(R.id.detailTitle);
        textDesc = findViewById(R.id.descDetail);
        textDate = findViewById(R.id.dateDetail);
        popularity = findViewById(R.id.popularity);

        imagePoster = findViewById(R.id.ivPoster);



        viewModel = new ViewModelProvider(this).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getString(EXTRA_FROM).equals("movie")){
                String courseId = extras.getString(EXTRA_MOVIE);
                if (courseId != null) {
                    viewModel.setSelectedCourse(courseId);
                    populateCourse(viewModel.getMovies());
                }
            }
            if (extras.getString(EXTRA_FROM).equals("tv")){
                String courseId = extras.getString(EXTRA_TV);
                if (courseId != null) {
                    viewModel.setSelectedCourse(courseId);
                    populateCourse(viewModel.getTV());
                }
            }
        }

    }

    private void populateCourse(MoviesEntity movies) {
        textTitle.setText(movies.getTitle());
        textDesc.setText(movies.getDesc());
        textDate.setText(movies.getDate());
        popularity.setText(movies.getPopularity());

        Glide.with(this)
                .load(movies.getImg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
    }
}