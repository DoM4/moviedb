package aumenta.domenico.com.movies.backend.interfaces;


import aumenta.domenico.com.movies.backend.models.Movie;
import aumenta.domenico.com.movies.backend.models.MovieCollection;
import aumenta.domenico.com.movies.backend.responses.NowPlayingMoviesResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public interface MovieDBService {

    //Get now playing movies
    @GET("movie/now_playing")
    Observable<NowPlayingMoviesResponse> getNowPlayingMovies(@Query("api_key") String api_key);

    //Get movie by Id
    @GET("movie/{movie_id}")
    Observable<Movie> getMovieDetails(@Path("movie_id") int movieId, @Query("api_key") String api_key);

    //Get collection by Id
    @GET("collection/{collection_id}")
    Observable<MovieCollection> getMovieCollection(@Path("collection_id") int collectionId, @Query("api_key") String api_key);


}
