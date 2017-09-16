package aumenta.domenico.com.movies.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import aumenta.domenico.com.movies.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

class MovieItemHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.movie_card_container)
    CardView movieCardView;

    @BindView(R.id.movie_poster)
    ImageView moviePoster;

    @BindView(R.id.movie_title)
    TextView movieTitle;

    @BindView(R.id.movie_vote_average)
    TextView movieAverageVote;

    public MovieItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
