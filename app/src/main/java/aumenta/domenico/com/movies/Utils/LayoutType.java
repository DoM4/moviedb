package aumenta.domenico.com.movies.Utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;


/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class LayoutType {
    @Retention(SOURCE)
    @StringDef({
            GRID,
            LINEAR_LAYOUT
    })
    public @interface CardLayout {}
    public static final String GRID = "GRID";
    public static final String LINEAR_LAYOUT = "LINEAR_LAYOUT";
}

