package com.auliaridhov.moviecatalog.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.utils.EspressoIdlingResource;
import com.auliaridhov.moviecatalog.viewmodel.ViewModelFactory;

public class MoviesFragment extends Fragment {

    private RecyclerView rvMovie;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {

            EspressoIdlingResource.increment();

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());


            MoviesViewModel viewModel = new ViewModelProvider(this, factory).get(MoviesViewModel.class);
            viewModel.getMovies().observe(this, courses -> {
                        progressBar.setVisibility(View.GONE);
                        MoviesAdapter moviesAdapter = new MoviesAdapter();

                        moviesAdapter.setCourses(courses);
                        moviesAdapter.notifyDataSetChanged();

                        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
                        rvMovie.setHasFixedSize(true);
                        rvMovie.setAdapter(moviesAdapter);

                        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                            EspressoIdlingResource.decrement();
                        }
                    }
            );

            //List<CourseEntity> courses = DataDummy.generateDummyCourses();

        }
    }
}