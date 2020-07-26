package com.example.mynews;

import java.io.Serializable;

public class NewsData implements Serializable {
    private String newsTitle;
    private String newsImage;
    private String newsSource;
    private String newsDate;
    private String newsData;



    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsData() {
        return newsData;
    }

    public void setNewsData(String newsData) {
        this.newsData = newsData;
    }
}
