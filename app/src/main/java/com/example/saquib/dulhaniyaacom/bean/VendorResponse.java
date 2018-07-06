package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorResponse {

    @SerializedName("cat_id")
    private String catId;

    @SerializedName("cat_name")
    private String catName;

    @SerializedName("cat_banner")
    private String catBanner;

    @SerializedName("cat_icon")
    private String catIcon;

    @SerializedName("count")
    private String count;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatBanner() {
        return catBanner;
    }

    public void setCatBanner(String catBanner) {
        this.catBanner = catBanner;
    }

    public String getCatIcon() {
        return catIcon;
    }

    public void setCatIcon(String catIcon) {
        this.catIcon = catIcon;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}