package aumenta.domenico.com.movies.backend.responses;

import android.content.Context;

import java.util.List;

import aumenta.domenico.com.movies.R;


/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class BaseResponse {
    private boolean Ok;
    private String GeneratedIn;
    private List<String> Errors;

    public BaseResponse() {}

    public boolean isOk() {
        return Ok;
    }

    String getGeneratedIn() {
        return GeneratedIn;
    }

    public List<String> getErrors() {
        return Errors;
    }

    /**
     * Get error message from response
     * @param ctx Application context
     * @return First error message in Errors array if present; Default message otherwise.
     */
    public String getErrorMessage(Context ctx){
        if(Errors != null && Errors.size() > 0) return Errors.get(0);
        return ctx.getString(R.string.default_error_message);
    }

}
