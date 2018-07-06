package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealWeddingResponse {

    @SerializedName("rw_id")
    @Expose
    private String rwId;
    @SerializedName("rw_title")
    @Expose
    private String rwTitle;
    @SerializedName("rw_slug")
    @Expose
    private String rwSlug;
    @SerializedName("rw_name")
    @Expose
    private String rwName;
    @SerializedName("rw_img")
    @Expose
    private String rwImg;
    @SerializedName("rw_about")
    @Expose
    private String rwAbout;
    @SerializedName("rw_location")
    @Expose
    private String rwLocation;
    @SerializedName("rw_date")
    @Expose
    private String rwDate;
    @SerializedName("rw_seotitle")
    @Expose
    private String rwSeotitle;
    @SerializedName("rw_seodesc")
    @Expose
    private String rwSeodesc;
    @SerializedName("rw_seokeywords")
    @Expose
    private String rwSeokeywords;
    @SerializedName("rw_views")
    @Expose
    private String rwViews;
    @SerializedName("rw_loves")
    @Expose
    private String rwLoves;
    @SerializedName("tag_id")
    @Expose
    private Object tagId;

    public String getRwId() {
        return rwId;
    }

    public void setRwId(String rwId) {
        this.rwId = rwId;
    }

    public String getRwTitle() {
        return rwTitle;
    }

    public void setRwTitle(String rwTitle) {
        this.rwTitle = rwTitle;
    }

    public String getRwSlug() {
        return rwSlug;
    }

    public void setRwSlug(String rwSlug) {
        this.rwSlug = rwSlug;
    }

    public String getRwName() {
        return rwName;
    }

    public void setRwName(String rwName) {
        this.rwName = rwName;
    }

    public String getRwImg() {
        return rwImg;
    }

    public void setRwImg(String rwImg) {
        this.rwImg = rwImg;
    }

    public String getRwAbout() {
        return rwAbout;
    }

    public void setRwAbout(String rwAbout) {
        this.rwAbout = rwAbout;
    }

    public String getRwLocation() {
        return rwLocation;
    }

    public void setRwLocation(String rwLocation) {
        this.rwLocation = rwLocation;
    }

    public String getRwDate() {
        return rwDate;
    }

    public void setRwDate(String rwDate) {
        this.rwDate = rwDate;
    }

    public String getRwSeotitle() {
        return rwSeotitle;
    }

    public void setRwSeotitle(String rwSeotitle) {
        this.rwSeotitle = rwSeotitle;
    }

    public String getRwSeodesc() {
        return rwSeodesc;
    }

    public void setRwSeodesc(String rwSeodesc) {
        this.rwSeodesc = rwSeodesc;
    }

    public String getRwSeokeywords() {
        return rwSeokeywords;
    }

    public void setRwSeokeywords(String rwSeokeywords) {
        this.rwSeokeywords = rwSeokeywords;
    }

    public String getRwViews() {
        return rwViews;
    }

    public void setRwViews(String rwViews) {
        this.rwViews = rwViews;
    }

    public String getRwLoves() {
        return rwLoves;
    }

    public void setRwLoves(String rwLoves) {
        this.rwLoves = rwLoves;
    }

    public Object getTagId() {
        return tagId;
    }

    public void setTagId(Object tagId) {
        this.tagId = tagId;
    }

}
