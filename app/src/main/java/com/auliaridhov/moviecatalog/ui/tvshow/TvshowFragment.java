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

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.ui.movies.MoviesAdapter;
import com.auliaridhov.moviecatalog.ui.movies.MoviesViewModel;

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

            TvshowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvshowViewModel.class);
            List<MoviesEntity> tvshow = viewModel.getTvShow();


            //List<CourseEntity> courses = DataDummy.generateDummyCourses();
            TvshowAdapter tvshowAdapter = new TvshowAdapter();
            tvshowAdapter.setTvShow(tvshow);

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(tvshowAdapter);
        }
    }
}