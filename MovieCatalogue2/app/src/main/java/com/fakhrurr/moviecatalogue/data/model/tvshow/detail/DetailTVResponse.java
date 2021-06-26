package com.fakhrurr.moviecatalogue.data.model.tvshow.detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.fakhrurr.moviecatalogue.data.local.entity.GenresItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailTVResponse implements Parcelable {

    public static final Creator<DetailTVResponse> CREATOR = new Creator<DetailTVResponse>() {
        @Override
        public DetailTVResponse createFromParcel(Parcel in) {
            return new DetailTVResponse(in);
        }

        @Override
        public DetailTVResponse[] newArray(int size) {
            return new DetailTVResponse[size];
        }
    };
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("number_of_episodes")
    private int numberOfEpisodes;
    @SerializedName("networks")
    private List<NetworksItem> networks;
    @SerializedName("type")
    private String type;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("genres")
    private List<GenresItem> genres;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("production_countries")
    private List<ProductionCountriesItem> productionCountries;
    @SerializedName("id")
    private int id;
    @SerializedName("number_of_seasons")
    private int numberOfSeasons;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("overview")
    private String overview;
    @SerializedName("seasons")
    private List<SeasonsItem> seasons;
    @SerializedName("languages")
    private List<String> languages;
    @SerializedName("created_by")
    private List<CreatedByItem> createdBy;
    @SerializedName("last_episode_to_air")
    private LastEpisodeToAir lastEpisodeToAir;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("origin_country")
    private List<String> originCountry;
    @SerializedName("spoken_languages")
    private List<SpokenLanguagesItem> spokenLanguages;
    @SerializedName("production_companies")
    private List<ProductionCompaniesItem> productionCompanies;
    @SerializedName("original_name")
    private String originalName;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("name")
    private String name;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("episode_run_time")
    private List<Integer> episodeRunTime;
    @SerializedName("next_episode_to_air")
    private Object nextEpisodeToAir;
    @SerializedName("in_production")
    private boolean inProduction;
    @SerializedName("last_air_date")
    private String lastAirDate;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("status")
    private String status;

    public DetailTVResponse(Parcel in) {
        originalLanguage = in.readString();
        numberOfEpisodes = in.readInt();
        type = in.readString();
        backdropPath = in.readString();
        popularity = in.readDouble();
        id = in.readInt();
        numberOfSeasons = in.readInt();
        voteCount = in.readInt();
        firstAirDate = in.readString();
        overview = in.readString();
        languages = in.createStringArrayList();
        posterPath = in.readString();
        originCountry = in.createStringArrayList();
        originalName = in.readString();
        voteAverage = in.readDouble();
        name = in.readString();
        tagline = in.readString();
        inProduction = in.readByte() != 0;
        lastAirDate = in.readString();
        homepage = in.readString();
        status = in.readString();
    }

    public DetailTVResponse() {

    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public List<NetworksItem> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworksItem> networks) {
        this.networks = networks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
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

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<SeasonsItem> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SeasonsItem> seasons) {
        this.seasons = seasons;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<CreatedByItem> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<CreatedByItem> createdBy) {
        this.createdBy = createdBy;
    }

    public LastEpisodeToAir getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public void setLastEpisodeToAir(LastEpisodeToAir lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public Object getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    public void setNextEpisodeToAir(Object nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    public boolean isInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
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
        dest.writeInt(numberOfEpisodes);
        dest.writeString(type);
        dest.writeString(backdropPath);
        dest.writeDouble(popularity);
        dest.writeInt(id);
        dest.writeInt(numberOfSeasons);
        dest.writeInt(voteCount);
        dest.writeString(firstAirDate);
        dest.writeString(overview);
        dest.writeStringList(languages);
        dest.writeString(posterPath);
        dest.writeStringList(originCountry);
        dest.writeString(originalName);
        dest.writeDouble(voteAverage);
        dest.writeString(name);
        dest.writeString(tagline);
        dest.writeByte((byte) (inProduction ? 1 : 0));
        dest.writeString(lastAirDate);
        dest.writeString(homepage);
        dest.writeString(status);
    }
}