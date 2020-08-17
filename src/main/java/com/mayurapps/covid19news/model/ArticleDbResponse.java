package com.mayurapps.covid19news.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleDbResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total_hits")
    @Expose
    private Integer totalHits;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("page_size")
    @Expose
    private Integer pageSize;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    @SerializedName("user_input")
    @Expose
    private UserInput userInput;
    public final static Parcelable.Creator<ArticleDbResponse> CREATOR = new Creator<ArticleDbResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ArticleDbResponse createFromParcel(Parcel in) {
            return new ArticleDbResponse(in);
        }

        public ArticleDbResponse[] newArray(int size) {
            return (new ArticleDbResponse[size]);
        }

    }
            ;

    protected ArticleDbResponse(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.totalHits = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pageSize = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.articles, (com.mayurapps.covid19news.model.Article.class.getClassLoader()));
        this.userInput = ((UserInput) in.readValue((UserInput.class.getClassLoader())));
    }

    public ArticleDbResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(totalHits);
        dest.writeValue(page);
        dest.writeValue(totalPages);
        dest.writeValue(pageSize);
        dest.writeList(articles);
        dest.writeValue(userInput);
    }

    public int describeContents() {
        return 0;
    }

}