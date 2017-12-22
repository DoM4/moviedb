package aumenta.domenico.com.movies.presenter;

import aumenta.domenico.com.movies.backend.Service;
import aumenta.domenico.com.movies.backend.ServiceCallback;
import aumenta.domenico.com.movies.backend.responses.BaseResponse;
import aumenta.domenico.com.movies.views.MovieView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by domenicoaumenta on 21/12/2017.
 */

public class MovieMainPresenter {
    private final Service service;
    private final MovieView view;
    private CompositeSubscription subscriptions;

    public MovieMainPresenter(Service service, MovieView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getPlayingMovies(){
        view.showWait();
        Subscription subscription = service.getPlayingMovies(new ServiceCallback() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                view.hideWait();
                view.getResponse(baseResponse);
            }

            @Override
            public void onError(String error) {
                view.hideWait();
                view.onFailure(error);
            }
        });

        subscriptions.add(subscription);
    }

    public void getMovieDetails(int movieId){
        view.showWait();
        Subscription subscription = service.getMovieDetails(movieId, new ServiceCallback() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                view.hideWait();
                view.getResponse(baseResponse);
            }

            @Override
            public void onError(String error) {
                view.hideWait();
                view.onFailure(error);
            }
        });

        subscriptions.add(subscription);
    }

    public void getCollectionByMovie(int collectionId){
        view.showWait();
            Subscription subscription = service.getCollectionByMovie(collectionId, new ServiceCallback() {
                @Override
                public void onSuccess(BaseResponse baseResponse) {
                    view.hideWait();
                    view.getResponse(baseResponse);
                }

                @Override
                public void onError(String error) {
                    view.hideWait();
                    view.onFailure(error);
                }
            });

        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
