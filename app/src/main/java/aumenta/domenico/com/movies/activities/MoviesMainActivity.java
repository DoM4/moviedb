package aumenta.domenico.com.movies.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import aumenta.domenico.com.movies.BuildConfig;
import aumenta.domenico.com.movies.R;
import aumenta.domenico.com.movies.Utils.LayoutType;
import aumenta.domenico.com.movies.Utils.Utils;
import aumenta.domenico.com.movies.adapters.MoviesAdapter;
import aumenta.domenico.com.movies.backend.ApiManager;
import aumenta.domenico.com.movies.backend.models.Movie;
import aumenta.domenico.com.movies.backend.responses.NowPlayingMoviesResponse;
import aumenta.domenico.com.movies.listeners.OnMovieListener;
import aumenta.domenico.com.movies.listeners.OnSnackBarActionListener;
import butterknife.BindView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviesMainActivity extends BaseActivity implements
        SwipeRefreshLayout.OnRefreshListener,
        OnMovieListener,
        OnSnackBarActionListener {

    private final String TAG = getClass().getSimpleName();

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesRecyclerView;

    @BindView(R.id.movies_container_view)
    ConstraintLayout moviesContainerView;

    List<Movie> movieList = new ArrayList<>();

    @Override
    void setupToolbar() {
        setupToolbarInActivity(getString(R.string.app_name), false);
    }

    @Override
    int getLayout() {
        return R.layout.activity_movies_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        swipeRefreshLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void downloadNowPlayingMovies() {
        resetFeeds();
        swipeRefreshLayout.setRefreshing(true);
        ApiManager.api().getNowPlayingMovies(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NowPlayingMoviesResponse>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                        setupRecyclerView();
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                        showMessage(moviesContainerView, e.getLocalizedMessage(), getString(R.string.retry), new OnSnackBarActionListener() {
                            @Override
                            public void onSnackBarActionClicked() {
                                onRefresh();
                            }
                        });
                    }

                    @Override
                    public void onNext(NowPlayingMoviesResponse nowPlayingMoviesResponse) {
                        movieList = (nowPlayingMoviesResponse.getNowPlayingMovies());
                    }
                });
    }

    /**
     * Clear movie lists
     */
    private void resetFeeds() {
        movieList.clear();
    }

    /**
     * Populate RecyclerView and attach ItemHelper to handle delete/swap gestures
     */
    private void setupRecyclerView() {
        MoviesAdapter moviesAdapter = new MoviesAdapter(movieList,this, LayoutType.GRID);
        moviesRecyclerView.setLayoutManager(new GridLayoutManager(MoviesMainActivity.this,2));
        moviesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        moviesRecyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public void onRefresh() {
        if (Utils.isNetworkAvailable(this)) {
            downloadNowPlayingMovies();
        } else {
            swipeRefreshLayout.setRefreshing(false);
            showMessage(moviesContainerView,
                    getString(R.string.no_internet_connection),
                    getString(R.string.retry)
                    , this);
        }
    }

    @Override
    public void onSnackBarActionClicked() {

    }

    @Override
    public void OnMovieClicked(int position, int movieId) {
        Intent intent = new Intent(MoviesMainActivity.this,MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE_ID,movieId);
        startActivity(intent);
    }
}
