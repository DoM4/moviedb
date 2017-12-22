package aumenta.domenico.com.movies.backend.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aumenta.domenico.com.movies.backend.responses.BaseResponse;

/**
 * Created by domenicoaumenta on 16/09/2017.
 */

public class MovieCollection extends BaseResponse {

    @SerializedName("id")
    private int MovieCollectionId;

    @SerializedName("name")
    private String Name;

    @SerializedName("overview")
    private String Overview;

    @SerializedName("poster_path")
    private String PosterPath;

    @SerializedName("backdrop_path")
    private String BackDropPath;

    @SerializedName("parts")
    private List<Movie> CollectionMoviesList;

    public int getMovieCollectionId() {
        return MovieCollectionId;
    }

    public void setMovieCollectionId(int movieCollectionId) {
        MovieCollectionId = movieCollectionId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public String getBackDropPath() {
        return BackDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        BackDropPath = backDropPath;
    }

    public List<Movie> getCollectionMoviesList() {
        return CollectionMoviesList;
    }

    public void setCollectionMoviesList(List<Movie> collectionMoviesList) {
        CollectionMoviesList = collectionMoviesList;
    }

    @Override
    public String toString() {
        return "MovieCollection{" +
                "MovieCollectionId=" + MovieCollectionId +
                ", Name='" + Name + '\'' +
                ", Overview='" + Overview + '\'' +
                ", PosterPath='" + PosterPath + '\'' +
                ", BackDropPath='" + BackDropPath + '\'' +
                ", CollectionMoviesList=" + CollectionMoviesList +
                '}';
    }
}
