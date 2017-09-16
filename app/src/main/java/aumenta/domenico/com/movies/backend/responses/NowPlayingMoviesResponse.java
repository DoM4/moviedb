package aumenta.domenico.com.movies.backend.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aumenta.domenico.com.movies.backend.models.Movie;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class NowPlayingMoviesResponse {
    @SerializedName("page")
    private int Page;

    @SerializedName("results")
    private List<Movie> NowPlayingMovies;

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public List<Movie> getNowPlayingMovies() {
        return NowPlayingMovies;
    }

    public void setNowPlayingMovies(List<Movie> nowPlayingMovies) {
        NowPlayingMovies = nowPlayingMovies;
    }

    @Override
    public String toString() {
        return "NowPlayingMoviewsResponse{" +
                "Page=" + Page +
                ", NowPlayingMovies=" + NowPlayingMovies +
                '}';
    }
}
