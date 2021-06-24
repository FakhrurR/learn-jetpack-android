package com.fakhrurr.moviecatalogue.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "detailmovieentity",
        primaryKeys = {"movieId", "tvShowId"},
        foreignKeys = @ForeignKey(entity = MovieEntity.class,
                parentColumns = "movieId",
                childColumns = "movieId"),
        indices = {@Index(value = "movieId"),
                @Index(value = "tvShowId")}
)
public class MovieDetailEntity implements Parcelable {

    @ColumnInfo(name = "firstAirDate")
    private String firstAirDate;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "imdbId")
    private String imdbId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "backdropPath")
    private String backdropPath;

    @ColumnInfo(name = "genres")
    private List<GenresItem> genres;

    @PrimaryKey
    @ColumnInfo(name = "movieId")
    private int id;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "originalTitle")
    private String originalTitle;

    @ColumnInfo(name = "posterPath")
    private Object posterPath;

    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    @ColumnInfo(name = "voteAverage")
    private double voteAverage;

    public MovieDetailEntity(String firstAirDate, String name, String imdbId, String title, String backdropPath, List<GenresItem> genres, int id, String overview, String originalTitle, Object posterPath, String releaseDate, double voteAverage) {
        this.firstAirDate = firstAirDate;
        this.name = name;
        this.imdbId = imdbId;
        this.title = title;
        this.backdropPath = backdropPath;
        this.genres = genres;
        this.id = id;
        this.overview = overview;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
    }

    protected MovieDetailEntity(Parcel in) {
        firstAirDate = in.readString();
        name = in.readString();
        imdbId = in.readString();
        title = in.readString();
        backdropPath = in.readString();
        genres = in.createTypedArrayList(GenresItem.CREATOR);
        id = in.readInt();
        overview = in.readString();
        originalTitle = in.readString();
        releaseDate = in.readString();
        voteAverage = in.readDouble();
    }

    public static final Creator<MovieDetailEntity> CREATOR = new Creator<MovieDetailEntity>() {
        @Override
        public MovieDetailEntity createFromParcel(Parcel in) {
            return new MovieDetailEntity(in);
        }

        @Override
        public MovieDetailEntity[] newArray(int size) {
            return new MovieDetailEntity[size];
        }
    };

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    public List<GenresItem> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresItem> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstAirDate);
        dest.writeString(name);
        dest.writeString(imdbId);
        dest.writeString(title);
        dest.writeString(backdropPath);
        dest.writeTypedList(genres);
        dest.writeInt(id);
        dest.writeString(overview);
        dest.writeString(originalTitle);
        dest.writeString(releaseDate);
        dest.writeDouble(voteAverage);
    }
}
