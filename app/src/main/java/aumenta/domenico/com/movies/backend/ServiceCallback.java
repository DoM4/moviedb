package aumenta.domenico.com.movies.backend;

import aumenta.domenico.com.movies.backend.responses.BaseResponse;

public interface ServiceCallback {
    void onSuccess(BaseResponse baseResponse);

    void onError(String error);
}
