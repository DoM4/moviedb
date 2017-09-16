package aumenta.domenico.com.movies.listeners;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public interface OnMovieListener {
    /**
     * Called when a Movie is clicked from RecyclerView
     * @param movieId of the movie to show in details
     * @param position the position of the movie in the recyclerView
     */
    void OnMovieClicked(int position, int movieId);

}
