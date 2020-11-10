package com.auliaridhov.moviecatalog.ui.tvshow;

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

public class TvshowAdapter extends RecyclerView.Adapter<com.auliaridhov.moviecatalog.ui.tvshow.TvshowAdapter.TvShowViewHolder> {
    private List<MoviesEntity> listMovies = new ArrayList<>();

    void setTvShow(List<MoviesEntity> movies) {
        if (movies == null) return;
        listMovies.clear();
        listMovies.addAll(movies);
    }

    @NonNull
    @Override
    public com.auliaridhov.moviecatalog.ui.tvshow.TvshowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new com.auliaridhov.moviecatalog.ui.tvshow.TvshowAdapter.TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final com.auliaridhov.moviecatalog.ui.tvshow.TvshowAdapter.TvShowViewHolder holder, int position) {
        MoviesEntity movies = listMovies.get(position);
        holder.bind(movies);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final ImageView imgPoster;

        TvShowViewHolder(View itemView) {
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
                intent.putExtra(DetailMovieActivity.EXTRA_FROM, "tv");
                intent.putExtra(DetailMovieActivity.EXTRA_TV, movies.getIdMovies());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(movies.getImg())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}

