package aumenta.domenico.com.movies.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import aumenta.domenico.com.movies.R;
import aumenta.domenico.com.movies.listeners.OnSnackBarActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.toolbar_title)
    public TextView toolbarTitle;

    public Snackbar snackbar;
    abstract void setupToolbar();

    @LayoutRes
    abstract int getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,getLayout());
        ButterKnife.bind(this);
        setupToolbar();
    }

    public void setupToolbarInActivity(String title,boolean showBackArrow){
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(showBackArrow);
            getSupportActionBar().setDisplayShowHomeEnabled(showBackArrow);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbarTitle.setText(title);
        if(!showBackArrow){
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }

    /**
     * Shows a Snackbar with given message
     * @param view View in which to anchor Snackbar
     * @param message String resource to display
     */
    void showMessage(View view, CharSequence message, CharSequence actiontext, final OnSnackBarActionListener snackBarActionListener){
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setActionTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
        snackbar.setAction(actiontext, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackBarActionListener.onSnackBarActionClicked();
            }
        });
        snackbar.show();
    }
}