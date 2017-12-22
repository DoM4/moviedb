package aumenta.domenico.com.movies.deps;

import javax.inject.Singleton;

import aumenta.domenico.com.movies.activities.MovieDetailsActivity;
import aumenta.domenico.com.movies.activities.MoviesActivity;
import aumenta.domenico.com.movies.backend.ApiManager;
import dagger.Component;

/**
 * Created by domenicoaumenta on 21/12/2017.
 */

@Singleton
@Component(modules = {ApiManager.class,})
public interface Deps {
    void inject(MoviesActivity moviesMainActivity);
    void inject(MovieDetailsActivity movieDetailsActivity);
}
