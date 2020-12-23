package com.auliaridhov.moviecatalog.ui.favorite.tvshow;

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
import com.auliaridhov.moviecatalog.ui.tvshow.TvshowAdapter;
import com.auliaridhov.moviecatalog.ui.tvshow.TvshowViewModel;
import com.auliaridhov.moviecatalog.viewmodel.ViewModelFactory;

public class FavoriteTvFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_favorite_tv, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {


            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvshowViewModel tvshowViewModel = new ViewModelProvider(this, factory).get(TvshowViewModel.class);
            TvshowAdapter adapter = new TvshowAdapter();

            tvshowViewModel.setUsername("auliaridhov");
            tvshowViewModel.tvFav.observe(this, movie -> {
                if (movie != null) {
                    progressBar.setVisibility(View.GONE);
                    adapter.setTvShow(movie);
                    adapter.notifyDataSetChanged();
                }
            });

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(adapter);

        }
    }
}