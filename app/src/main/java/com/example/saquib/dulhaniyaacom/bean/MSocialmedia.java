package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MSocialmedia {

    @SerializedName("instagram")
    @Expose
    private String instagram;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("youtube")
    @Expose
    private String youtube;
    @SerializedName("pinterest")
    @Expose
    private String pinterest;
    @SerializedName("google")
    @Expose
    private String google;

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getPinterest() {
        return pinterest;
    }

    public void setPinterest(String pinterest) {
        this.pinterest = pinterest;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

}
