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

    @SerializedName("belongs_to_collection")
    private MovieCollection Collection;

    @SerializedName("budget")
    private int Budget;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("imdb_id")
    private String IMDB;

    @SerializedName("production_companies")
    private List<ProductCompanies> ProductCompaniesList;

    @SerializedName("production_countries")
    private List<ProductionCountries> ProductionCountriesList;

    @SerializedName("revenue")
    private int Revenue;

    @SerializedName("runtime")
    private int Runtime;

    @SerializedName("spoken_languages")
    private List<SpokenLanguages> SpokenLanguagesList;

    @SerializedName("status")
    private String Status;

    @SerializedName("tagline")
    private String TagLine;

    @SerializedName("title")
    private String Title;


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

    public MovieCollection getCollection() {
        return Collection;
    }

    public void setCollection(MovieCollection collection) {
        Collection = collection;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getIMDB() {
        return IMDB;
    }

    public void setIMDB(String IMDB) {
        this.IMDB = IMDB;
    }

    public List<ProductCompanies> getProductCompaniesList() {
        return ProductCompaniesList;
    }

    public void setProductCompaniesList(List<ProductCompanies> productCompaniesList) {
        ProductCompaniesList = productCompaniesList;
    }

    public List<ProductionCountries> getProductionCountriesList() {
        return ProductionCountriesList;
    }

    public void setProductionCountriesList(List<ProductionCountries> productionCountriesList) {
        ProductionCountriesList = productionCountriesList;
    }

    public int getRevenue() {
        return Revenue;
    }

    public void setRevenue(int revenue) {
        Revenue = revenue;
    }

    public int getRuntime() {
        return Runtime;
    }

    public void setRuntime(int runtime) {
        Runtime = runtime;
    }

    public List<SpokenLanguages> getSpokenLanguagesList() {
        return SpokenLanguagesList;
    }

    public void setSpokenLanguagesList(List<SpokenLanguages> spokenLanguagesList) {
        SpokenLanguagesList = spokenLanguagesList;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTagLine() {
        return TagLine;
    }

    public void setTagLine(String tagLine) {
        TagLine = tagLine;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
                ", Collection=" + Collection +
                ", Budget=" + Budget +
                ", homepage='" + homepage + '\'' +
                ", IMDB='" + IMDB + '\'' +
                ", ProductCompaniesList=" + ProductCompaniesList +
                ", ProductionCountriesList=" + ProductionCountriesList +
                ", Revenue=" + Revenue +
                ", Runtime=" + Runtime +
                ", SpokenLanguagesList=" + SpokenLanguagesList +
                ", Status='" + Status + '\'' +
                ", TagLine='" + TagLine + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
}
