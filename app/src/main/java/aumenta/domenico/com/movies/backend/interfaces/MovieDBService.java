package aumenta.domenico.com.movies.backend.interfaces;


import aumenta.domenico.com.movies.backend.responses.NowPlayingMoviesResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public interface MovieDBService {

    //Get articles feeds
    @GET("movie/now_playing")
    Observable<NowPlayingMoviesResponse> getNowPlayingMovies(@Query("api_key") String api_key);

}
