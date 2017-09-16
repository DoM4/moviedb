package aumenta.domenico.com.movies.backend.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Locale;

import aumenta.domenico.com.movies.BuildConfig;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class Movie {

    @SerializedName("poster_path")
    private String PosterPath;

    @SerializedName("adult")
    private boolean isAdultMovie;

    @SerializedName("overview")
    private String Overview;

    @SerializedName("release_date")
    private String ReleaseDate;

    @SerializedName("genre_ids")
    private List<Integer> GenderListIds;

    @SerializedName("id")
    private int MovieId;

    @SerializedName("original_title")
    private String OriginalTitle;

    @SerializedName("original_language")
    private String OriginalLanguage;

    @SerializedName("backdrop_path")
    private String BackDropPath;

    @SerializedName("popularity")
    private double Popularity;

    @SerializedName("vote_count")
    private int VoteCount;

    @SerializedName("video")
    private boolean HasVideo;

    @SerializedName("vote_average")
    private float VoteAverage;

    public String getPosterPath() {
        String url = String.format(Locale.getDefault(),"%s%s", BuildConfig.POSTER_BASE_URL, PosterPath);
        return url;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public boolean isAdultMovie() {
        return isAdultMovie;
    }

    public void setAdultMovie(boolean adultMovie) {
        isAdultMovie = adultMovie;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public List<Integer> getGenderListIds() {
        return GenderListIds;
    }

    public void setGenderListIds(List<Integer> genderListIds) {
        GenderListIds = genderListIds;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int movieId) {
        MovieId = movieId;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        OriginalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return OriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        OriginalLanguage = originalLanguage;
    }

    public String getBackDropPath() {
        return BackDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        BackDropPath = backDropPath;
    }

    public double getPopularity() {
        return Popularity;
    }

    public void setPopularity(double popularity) {
        Popularity = popularity;
    }

    public int getVoteCount() {
        return VoteCount;
    }

    public void setVoteCount(int voteCount) {
        VoteCount = voteCount;
    }

    public boolean isHasVideo() {
        return HasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        HasVideo = hasVideo;
    }

    public float getVoteAverage() {
        return VoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        VoteAverage = voteAverage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "PosterPath='" + PosterPath + '\'' +
                ", isAdultMovie=" + isAdultMovie +
                ", Overview='" + Overview + '\'' +
                ", ReleaseDate='" + ReleaseDate + '\'' +
                ", GenderListIds=" + GenderListIds +
                ", MovieId=" + MovieId +
                ", OriginalTitle='" + OriginalTitle + '\'' +
                ", OriginalLanguage='" + OriginalLanguage + '\'' +
                ", BackDropPath='" + BackDropPath + '\'' +
                ", Popularity=" + Popularity +
                ", VoteCount=" + VoteCount +
                ", HasVideo=" + HasVideo +
                ", VoteAverage=" + VoteAverage +
                '}';
    }
}
