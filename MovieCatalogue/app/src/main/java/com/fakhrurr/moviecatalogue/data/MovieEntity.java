package com.fakhrurr.moviecatalogue.data;

public class MovieEntity {
    private String movieId;
    private String title;
    private String description;
    private String date;
    private String author;
    private String imagePath;

    public MovieEntity(String movieId, String title, String description, String date, String author, String imagePath) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.author = author;
        this.imagePath = imagePath;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
