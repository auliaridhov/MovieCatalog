package com.auliaridhov.moviecatalog.ui.favorite.movies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.ui.movies.MoviesAdapter;
import com.auliaridhov.moviecatalog.ui.movies.MoviesViewModel;
import com.auliaridhov.moviecatalog.viewmodel.ViewModelFactory;

public class FavoriteMovieFragment extends Fragment {
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
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false);

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

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            MoviesViewModel movieViewModel = new ViewModelProvider(this, factory).get(MoviesViewModel.class);
            MoviesAdapter adapter = new MoviesAdapter();
            movieViewModel.setUsername("auliaridhov");
//            movieViewModel.movies.observe(this, movie -> {
//                if (movie != null) {
//                    switch (movie.status) {
//                        case SUCCESS:
//                            progressBar.setVisibility(View.GONE);
//                            adapter.setCourses(movie.data);
//                            adapter.notifyDataSetChanged();
//                            break;
//                        case LOADING:
//                            progressBar.setVisibility(View.VISIBLE);
//                            break;
//                        case ERROR:
//                            progressBar.setVisibility(View.GONE);
//                            Toast.makeText(getContext(), "Ada Kesalahan Pada Aplikasi", Toast.LENGTH_SHORT).show();
//                            break;
//                    }
//                }
//
//            });

            movieViewModel.moviesFav.observe(this, movie -> {
                if (movie != null) {
                    progressBar.setVisibility(View.GONE);
                    adapter.setCourses(movie);
                    adapter.notifyDataSetChanged();
                }
            });
            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(adapter);

        }
    }

}