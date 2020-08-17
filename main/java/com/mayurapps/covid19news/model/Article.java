package com.mayurapps.covid19news.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Article implements Parcelable
{

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("author")
    @Expose
    private Object author;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("media")
    @Expose
    private Object media;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("media_content")
    @Expose
    private Object mediaContent;
    @SerializedName("clean_url")
    @Expose
    private String cleanUrl;
    @SerializedName("rights")
    @Expose
    private Object rights;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("_score")
    @Expose
    private Double score;
    public final static Parcelable.Creator<Article> CREATOR = new Creator<Article>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        public Article[] newArray(int size) {
            return (new Article[size]);
        }

    }
            ;

    protected Article(Parcel in) {
        this.summary = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((Object) in.readValue((Object.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.media = ((Object) in.readValue((Object.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.mediaContent = ((Object) in.readValue((Object.class.getClassLoader())));
        this.cleanUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.rights = ((Object) in.readValue((Object.class.getClassLoader())));
        this.rank = ((String) in.readValue((String.class.getClassLoader())));
        this.topic = ((String) in.readValue((String.class.getClassLoader())));
        this.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.score = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public Article() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getAuthor() {
        return author;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(Object mediaContent) {
        this.mediaContent = mediaContent;
    }

    public String getCleanUrl() {
        return cleanUrl;
    }

    public void setCleanUrl(String cleanUrl) {
        this.cleanUrl = cleanUrl;
    }

    public Object getRights() {
        return rights;
    }

    public void setRights(Object rights) {
        this.rights = rights;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(summary);
        dest.writeValue(country);
        dest.writeValue(author);
        dest.writeValue(link);
        dest.writeValue(language);
        dest.writeValue(media);
        dest.writeValue(title);
        dest.writeValue(mediaContent);
        dest.writeValue(cleanUrl);
        dest.writeValue(rights);
        dest.writeValue(rank);
        dest.writeValue(topic);
        dest.writeValue(publishedDate);
        dest.writeValue(id);
        dest.writeValue(score);
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return "Article{" +
                "summary='" + summary + '\'' +
                ", country='" + country + '\'' +
                ", author=" + author +
                ", link='" + link + '\'' +
                ", language='" + language + '\'' +
                ", media=" + media +
                ", title='" + title + '\'' +
                ", mediaContent=" + mediaContent +
                ", cleanUrl='" + cleanUrl + '\'' +
                ", rights=" + rights +
                ", rank='" + rank + '\'' +
                ", topic='" + topic + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", id='" + id + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Article)
        {
            Article temp = (Article) obj;
            return this.title.equals(temp.title);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.title.hashCode());
    }
}