package com.badrulacademy.topnewsinternation.services.model;

/*
public class ModelClass {
}
*/


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelClass {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("articles")
    @Expose
    private List<ModelDataClass> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<ModelDataClass> getArticles() {
        return articles;
    }

    public void setArticles(List<ModelDataClass> articles) {
        this.articles = articles;
    }

}