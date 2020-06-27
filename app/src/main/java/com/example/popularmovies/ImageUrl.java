package com.example.popularmovies;

public class ImageUrl {
    String imageUrl,title,backPath,overView,releaseDate;

    public ImageUrl(String imageUrl, String title, String backPath, String overView, String releaseDate) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.backPath = backPath;
        this.overView = overView;
        this.releaseDate = releaseDate;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackPath() {
        return backPath;
    }

    public void setBackPath(String backPath) {
        this.backPath = backPath;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
