package aumenta.domenico.com.movies.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

import aumenta.domenico.com.movies.R;
import aumenta.domenico.com.movies.backend.models.Movie;
import aumenta.domenico.com.movies.listeners.OnMovieListener;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieItemHolder> {

    List<Movie> movieList;
    OnMovieListener onMovieListener;

    public MoviesAdapter(List<Movie> movieList, OnMovieListener onMovieListener) {
        this.movieList = movieList;
        this.onMovieListener = onMovieListener;
    }


    @Override
    public MovieItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_card_view, parent,
                false).getRoot();
        return new MovieItemHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieItemHolder holder, final int position) {
        final Movie movie = this.movieList.get(position);

        holder.movieTitle.setText(movie.getOriginalTitle());
        holder.movieAverageVote.setText(String.format(Locale.getDefault(), "%.1f out of 10", movie.getVoteAverage()));
        Glide.with(holder.moviePoster.getContext())
                .load(movie.getPosterPath())
                .into(holder.moviePoster);
        holder.movieCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMovieListener.OnMovieClicked(position, movie.getMovieId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }
}
