package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BlogResponse implements Serializable {

    @SerializedName("blog_id")
    @Expose
    private String blogId;
    @SerializedName("bcat_id")
    @Expose
    private String bcatId;
    @SerializedName("blog_title")
    @Expose
    private String blogTitle;
    @SerializedName("blog_desc")
    @Expose
    private String blogDesc;
    @SerializedName("blog_img")
    @Expose
    private String blogImg;
    @SerializedName("blog_slug")
    @Expose
    private String blogSlug;
    @SerializedName("blog_date")
    @Expose
    private String blogDate;
    @SerializedName("blog_views")
    @Expose
    private String blogViews;
    @SerializedName("blog_love")
    @Expose
    private String blogLove;
    @SerializedName("seo_title")
    @Expose
    private String seoTitle;
    @SerializedName("seo_desc")
    @Expose
    private String seoDesc;
    @SerializedName("seo_keywords")
    @Expose
    private String seoKeywords;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBcatId() {
        return bcatId;
    }

    public void setBcatId(String bcatId) {
        this.bcatId = bcatId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc;
    }

    public String getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg;
    }

    public String getBlogSlug() {
        return blogSlug;
    }

    public void setBlogSlug(String blogSlug) {
        this.blogSlug = blogSlug;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(String blogViews) {
        this.blogViews = blogViews;
    }

    public String getBlogLove() {
        return blogLove;
    }

    public void setBlogLove(String blogLove) {
        this.blogLove = blogLove;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDesc() {
        return seoDesc;
    }

    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

}