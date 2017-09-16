package aumenta.domenico.com.movies.backend;

import android.content.Context;
import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;

import aumenta.domenico.com.movies.BuildConfig;
import aumenta.domenico.com.movies.R;
import aumenta.domenico.com.movies.backend.interfaces.MovieDBService;
import aumenta.domenico.com.movies.backend.responses.BaseResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class ApiManager {
    // Singleton manager
    private static ApiManager instance;
    // MovieDB Backend inflated by Retrofit
    private MovieDBService backend;
    // MovieDB Retrofit instance
    private Retrofit moviesRetrofit;
    // Private constructor - creates MovieDB backend
    private ApiManager(){
        setupMovieDBBackend();
    }

    /**
     * Retrieves MovieDBBackend from ApiManager instance
     * @return MovieDBBackend populated by ApiManager
     */
    public static MovieDBService api(){
        return getInstance().getBackend();
    }

    /**
     * Get ApiManager instance
     * @return ApiManager instance
     */
    public static ApiManager getInstance() {
        if(instance == null){
            instance = new ApiManager();
        }
        return instance;
    }

    /**
     * Get error message from response object
     * Default error message is used should no API specified error message exist
     * @param ctx Application context
     * @param response Response object from call
     * @return Error message from API or default error message
     */
    public String getApiError(Context ctx, Response response) {
        BaseResponse baseResponse = getErrorConverter(response.errorBody());
        return baseResponse != null ? baseResponse.getErrorMessage(ctx) : ctx.getString(R.string.default_error_message);
    }

    // Get backend
    private MovieDBService getBackend() {
        return backend;
    }

    // Sets up backend for MovieDB
    private void setupMovieDBBackend() {

        // build retrofit instance with url configured in build flavour
        moviesRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create backend from retrofit
        backend = moviesRetrofit.create(MovieDBService.class);
    }

    // Get base response from Error converter
    @Nullable
    private BaseResponse getErrorConverter(ResponseBody responseBody) {
        try {
            // Attempt conversion
            Converter<ResponseBody, BaseResponse> errorConverter = moviesRetrofit.responseBodyConverter(BaseResponse.class, new Annotation[0]);
            return errorConverter.convert(responseBody);
        } catch (Exception e) {
            // Could not convert to BaseResponse
            e.printStackTrace();
            return null;
        }
    }


}
