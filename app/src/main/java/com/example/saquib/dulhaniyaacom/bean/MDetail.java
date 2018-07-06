package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MDetail {

    @SerializedName("About")
    @Expose
    private String about;
    @SerializedName("Height")
    @Expose
    private String height;
    @SerializedName("Bust")
    @Expose
    private String bust;
    @SerializedName("Waist")
    @Expose
    private String waist;
    @SerializedName("Hips")
    @Expose
    private String hips;
    @SerializedName("Eyes")
    @Expose
    private String eyes;
    @SerializedName("Hair")
    @Expose
    private String hair;
    @SerializedName("DressSize")
    @Expose
    private String dressSize;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHips() {
        return hips;
    }

    public void setHips(String hips) {
        this.hips = hips;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getDressSize() {
        return dressSize;
    }

    public void setDressSize(String dressSize) {
        this.dressSize = dressSize;
    }

}
