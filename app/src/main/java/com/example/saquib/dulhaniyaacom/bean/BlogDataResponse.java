package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlogDataResponse {

    @SerializedName("bpost_id")
    @Expose
    private String bpostId;
    @SerializedName("blog_id")
    @Expose
    private String blogId;
    @SerializedName("bpost_img")
    @Expose
    private String bpostImg;
    @SerializedName("bpost_data")
    @Expose
    private String bpostData;
    @SerializedName("blog_para_heading")
    @Expose
    private String blogParaHeading;

    public String getBpostId() {
        return bpostId;
    }

    public void setBpostId(String bpostId) {
        this.bpostId = bpostId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBpostImg() {
        return bpostImg;
    }

    public void setBpostImg(String bpostImg) {
        this.bpostImg = bpostImg;
    }

    public String getBpostData() {
        return bpostData;
    }

    public void setBpostData(String bpostData) {
        this.bpostData = bpostData;
    }

    public String getBlogParaHeading() {
        return blogParaHeading;
    }

    public void setBlogParaHeading(String blogParaHeading) {
        this.blogParaHeading = blogParaHeading;
    }

}
