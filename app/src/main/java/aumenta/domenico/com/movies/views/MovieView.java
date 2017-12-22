package aumenta.domenico.com.movies.views;

import aumenta.domenico.com.movies.backend.responses.BaseResponse;

/**
 * Created by domenicoaumenta on 21/12/2017.
 */

public interface MovieView {
    void showWait();
    void hideWait();
    void onFailure(String errorMessage);
    void getResponse(BaseResponse baseResponse);
}
