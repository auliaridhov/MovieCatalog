package com.auliaridhov.moviecatalog.ui.tvshow;

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
import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.data.source.local.entity.TvShowLocalEntity;
import com.auliaridhov.moviecatalog.data.source.remote.response.ResultsItem;
import com.auliaridhov.moviecatalog.ui.movies.MoviesAdapter;
import com.auliaridhov.moviecatalog.ui.movies.MoviesViewModel;
import com.auliaridhov.moviecatalog.utils.EspressoIdlingResource;
import com.auliaridhov.moviecatalog.viewmodel.ViewModelFactory;

import java.util.List;


public class TvshowFragment extends Fragment {

    private RecyclerView rvMovie;
    private ProgressBar progressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_tv);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvshowViewModel tvshowViewModel = new ViewModelProvider(this, factory).get(TvshowViewModel.class);
            TvshowAdapter adapter = new TvshowAdapter();

            tvshowViewModel.setUsername("auliaridhov");
            tvshowViewModel.tv.observe(this, movie -> {
                if (movie != null) {
                    switch (movie.status) {
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            adapter.setTvShow(movie.data);
                            adapter.notifyDataSetChanged();
                            break;
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Ada Kesalahan Pada Aplikasi", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            });

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(adapter);


        }
    }
}