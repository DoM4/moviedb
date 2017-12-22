package aumenta.domenico.com.movies.backend;

import aumenta.domenico.com.movies.BuildConfig;
import aumenta.domenico.com.movies.backend.interfaces.MovieDBService;
import aumenta.domenico.com.movies.backend.models.Movie;
import aumenta.domenico.com.movies.backend.models.MovieCollection;
import aumenta.domenico.com.movies.backend.responses.NowPlayingMoviesResponse;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by domenicoaumenta on 21/12/2017.
 */

public class Service {
    private final MovieDBService movieDBService;

    public Service(MovieDBService movieDBService) {
        this.movieDBService = movieDBService;
    }

    public Subscription getPlayingMovies(final ServiceCallback callback){
        return this.movieDBService.getNowPlayingMovies(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends NowPlayingMoviesResponse>>() {
                    @Override
                    public Observable<? extends NowPlayingMoviesResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Observer<NowPlayingMoviesResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(NowPlayingMoviesResponse nowPlayingMoviesResponse) {
                        callback.onSuccess(nowPlayingMoviesResponse);
                    }
                });
    }

    public Subscription getMovieDetails(int movieId, final ServiceCallback callback){
        return this.movieDBService.getMovieDetails(movieId,BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                       callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(Movie movie) {
                      callback.onSuccess(movie);
                    }
                });
    }

    public Subscription getCollectionByMovie(int movieCollectionId, final ServiceCallback callback){
            return this.movieDBService.getMovieCollection(movieCollectionId,BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<MovieCollection>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            callback.onError(e.getMessage());
                        }

                        @Override
                        public void onNext(MovieCollection movieCollectionOnNext) {
                            callback.onSuccess(movieCollectionOnNext);
                        }
                    });
        }
    }

