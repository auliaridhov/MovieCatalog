package com.auliaridhov.moviecatalog.ui.movies;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.auliaridhov.moviecatalog.R;
import com.auliaridhov.moviecatalog.data.MoviesEntity;
import com.auliaridhov.moviecatalog.ui.detail.DetailMovieActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<MoviesEntity> listMovies = new ArrayList<>();

    void setCourses(List<MoviesEntity> movies) {
        if (movies == null) return;
        listMovies.clear();
        listMovies.addAll(movies);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        MoviesEntity movies = listMovies.get(position);
        holder.bind(movies);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final ImageView imgPoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }

        void bind(final MoviesEntity movies) {
            tvTitle.setText(movies.getTitle());
            tvDescription.setText(movies.getDesc());
            //tvDate.setText(itemView.getResources().getString(R.string.deadline_date, course.getDeadline()));
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_FROM, "movie");
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.getIdMovies());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(movies.getImg())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}

