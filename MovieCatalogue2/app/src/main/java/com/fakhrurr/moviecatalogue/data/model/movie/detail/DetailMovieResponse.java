package com.fakhrurr.moviecatalogue.data.model.movie.detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.fakhrurr.moviecatalogue.data.local.entity.GenresItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailMovieResponse implements Parcelable {

    public static final Creator<DetailMovieResponse> CREATOR = new Creator<DetailMovieResponse>() {
        @Override
        public DetailMovieResponse createFromParcel(Parcel in) {
            return new DetailMovieResponse(in);
        }

        @Override
        public DetailMovieResponse[] newArray(int size) {
            return new DetailMovieResponse[size];
        }
    };
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("video")
    private boolean video;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("revenue")
    private int revenue;
    @SerializedName("genres")
    private List<GenresItem> genres;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("production_countries")
    private List<ProductionCountriesItem> productionCountries;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("budget")
    private int budget;
    @SerializedName("overview")
    private String overview;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("poster_path")
    private Object posterPath;
    @SerializedName("spoken_languages")
    private List<SpokenLanguagesItem> spokenLanguages;
    @SerializedName("production_companies")
    private List<ProductionCompaniesItem> productionCompanies;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("belongs_to_collection")
    private Object belongsToCollection;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("status")
    private String status;

    public DetailMovieResponse(Parcel in) {
        originalLanguage = in.readString();
        imdbId = in.readString();
        video = in.readByte() != 0;
        title = in.readString();
        backdropPath = in.readString();
        revenue = in.readInt();
        popularity = in.readDouble();
        id = in.readInt();
        voteCount = in.readInt();
        budget = in.readInt();
        overview = in.readString();
        originalTitle = in.readString();
        runtime = in.readInt();
        releaseDate = in.readString();
        voteAverage = in.readDouble();
        tagline = in.readString();
        adult = in.readByte() != 0;
        homepage = in.readString();
        status = in.readString();
    }

    public DetailMovieResponse() {

    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public List<GenresItem> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresItem> genres) {
        this.genres = genres;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<ProductionCountriesItem> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountriesItem> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Object getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    public List<SpokenLanguagesItem> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguagesItem> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<ProductionCompaniesItem> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompaniesItem> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(originalLanguage);
        dest.writeString(imdbId);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeString(title);
        dest.writeString(backdropPath);
        dest.writeInt(revenue);
        dest.writeDouble(popularity);
        dest.writeInt(id);
        dest.writeInt(voteCount);
        dest.writeInt(budget);
        dest.writeString(overview);
        dest.writeString(originalTitle);
        dest.writeInt(runtime);
        dest.writeString(releaseDate);
        dest.writeDouble(voteAverage);
        dest.writeString(tagline);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(homepage);
        dest.writeString(status);
    }
}