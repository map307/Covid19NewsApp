package com.mayurapps.covid19news.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInput implements Parcelable {

    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("search_in")
    @Expose
    private String searchIn;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private Object to;
    @SerializedName("ranked_only")
    @Expose
    private String rankedOnly;
    @SerializedName("from_rank")
    @Expose
    private Object fromRank;
    @SerializedName("to_rank")
    @Expose
    private Object toRank;
    @SerializedName("sort_by")
    @Expose
    private String sortBy;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("sources")
    @Expose
    private Object sources;
    @SerializedName("not_sources")
    @Expose
    private Object notSources;
    @SerializedName("topic")
    @Expose
    private Object topic;
    @SerializedName("media")
    @Expose
    private String media;
    public final static Parcelable.Creator<UserInput> CREATOR = new Creator<UserInput>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserInput createFromParcel(Parcel in) {
            return new UserInput(in);
        }

        public UserInput[] newArray(int size) {
            return (new UserInput[size]);
        }

    };

    protected UserInput(Parcel in) {
        this.q = ((String) in.readValue((String.class.getClassLoader())));
        this.searchIn = ((String) in.readValue((String.class.getClassLoader())));
        this.lang = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((Object) in.readValue((Object.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((Object) in.readValue((Object.class.getClassLoader())));
        this.rankedOnly = ((String) in.readValue((String.class.getClassLoader())));
        this.fromRank = ((Object) in.readValue((Object.class.getClassLoader())));
        this.toRank = ((Object) in.readValue((Object.class.getClassLoader())));
        this.sortBy = ((String) in.readValue((String.class.getClassLoader())));
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.size = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sources = ((Object) in.readValue((Object.class.getClassLoader())));
        this.notSources = ((Object) in.readValue((Object.class.getClassLoader())));
        this.topic = ((Object) in.readValue((Object.class.getClassLoader())));
        this.media = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserInput() {
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getSearchIn() {
        return searchIn;
    }

    public void setSearchIn(String searchIn) {
        this.searchIn = searchIn;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }

    public String getRankedOnly() {
        return rankedOnly;
    }

    public void setRankedOnly(String rankedOnly) {
        this.rankedOnly = rankedOnly;
    }

    public Object getFromRank() {
        return fromRank;
    }

    public void setFromRank(Object fromRank) {
        this.fromRank = fromRank;
    }

    public Object getToRank() {
        return toRank;
    }

    public void setToRank(Object toRank) {
        this.toRank = toRank;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Object getSources() {
        return sources;
    }

    public void setSources(Object sources) {
        this.sources = sources;
    }

    public Object getNotSources() {
        return notSources;
    }

    public void setNotSources(Object notSources) {
        this.notSources = notSources;
    }

    public Object getTopic() {
        return topic;
    }

    public void setTopic(Object topic) {
        this.topic = topic;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(q);
        dest.writeValue(searchIn);
        dest.writeValue(lang);
        dest.writeValue(country);
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(rankedOnly);
        dest.writeValue(fromRank);
        dest.writeValue(toRank);
        dest.writeValue(sortBy);
        dest.writeValue(page);
        dest.writeValue(size);
        dest.writeValue(sources);
        dest.writeValue(notSources);
        dest.writeValue(topic);
        dest.writeValue(media);
    }

    public int describeContents() {
        return 0;
    }
}