package aumenta.domenico.com.movies.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

import javax.inject.Inject;

import aumenta.domenico.com.movies.R;
import aumenta.domenico.com.movies.Utils.LayoutType;
import aumenta.domenico.com.movies.adapters.MoviesAdapter;
import aumenta.domenico.com.movies.backend.Service;
import aumenta.domenico.com.movies.backend.models.Movie;
import aumenta.domenico.com.movies.backend.models.MovieCollection;
import aumenta.domenico.com.movies.backend.responses.BaseResponse;
import aumenta.domenico.com.movies.listeners.OnMovieListener;
import aumenta.domenico.com.movies.listeners.OnSnackBarActionListener;
import aumenta.domenico.com.movies.presenter.MovieMainPresenter;
import aumenta.domenico.com.movies.views.MovieView;
import butterknife.BindView;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class MovieDetailsActivity extends BaseActivity implements OnMovieListener, MovieView {

    public final String TAG = getClass().getSimpleName();
    private int movieId;
    private Movie movieDetails;
    private MovieCollection movieCollection;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.movie_bg_image)
    ImageView movieBG;

    @BindView(R.id.movie_releaseDate)
    TextView movieReleaseDate;

    @BindView(R.id.movie_description)
    TextView movieDescription;

    @BindView(R.id.movie_home_page)
    TextView movieHomePage;

    @BindView(R.id.movie_title)
    TextView movieTitle;

    @BindView(R.id.collection_recycler_view)
    RecyclerView collectionRecyclerView;

    @BindView(R.id.movie_details_container)
    CoordinatorLayout movieDetailsContainer;

    MovieMainPresenter movieMainPresenter;
    @Inject
    Service service;

    @Override
    void setupToolbar() {
    }

    @Override
    int getLayout() {
        return R.layout.activity_movie_details;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getExtras();
        getDeps().inject(this);
        movieMainPresenter = new MovieMainPresenter(service, this);
        movieMainPresenter.getMovieDetails(movieId);
    }

    private void getExtras() {
        if (getIntent().getExtras() != null) {
            movieId = getIntent().getIntExtra(EXTRA_MOVIE_ID, 0);
        }
    }

    private void populateLayout() {
        Glide.with(MovieDetailsActivity.this)
                .load(movieDetails.getPosterPath())
                .into(movieBG);

        movieTitle.setText(movieDetails.getTitle());
        movieReleaseDate.setText(String.format(Locale.getDefault(), "Release Date : %s", movieDetails.getReleaseDate()));
        movieDescription.setText(String.format(Locale.getDefault(), "Description : %s", movieDetails.getOverview()));
        movieHomePage.setText(String.format(Locale.getDefault(), "HomePage : %s", movieDetails.getHomepage()));
        movieHomePage.setVisibility(!movieDetails.getHomepage().isEmpty() ? View.VISIBLE : View.GONE);

        if (movieDetails.getCollection() != null) {
            movieMainPresenter.getCollectionByMovie(movieDetails.getCollection().getMovieCollectionId());
        }
    }

    private void populateCollectionList() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(MovieDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false);
        collectionRecyclerView.setLayoutManager(layoutManager);
        collectionRecyclerView.setAdapter(new MoviesAdapter(movieCollection.getCollectionMoviesList(), this, LayoutType.LINEAR_LAYOUT));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnMovieClicked(int position, int movieId) {
        Intent intent = new Intent(MovieDetailsActivity.this, MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE_ID, movieId);
        startActivity(intent);
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String errorMessage) {
        showMessage(movieDetailsContainer, errorMessage, getString(R.string.retry), new OnSnackBarActionListener() {
            @Override
            public void onSnackBarActionClicked() {
                movieMainPresenter.getMovieDetails(movieId);
            }
        });
    }

    @Override
    public void getResponse(BaseResponse baseResponse) {
        if (baseResponse instanceof Movie) {
            movieDetails = (Movie) baseResponse;
            setupToolbarInActivity(movieDetails.getTitle(), true);
            populateLayout();
        }else if(baseResponse instanceof MovieCollection){
            movieCollection = (MovieCollection) baseResponse;
            populateCollectionList();
        }
    }
}
