package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modelphotoshoot {

    @SerializedName("s_id")
    @Expose
    private String sId;
    @SerializedName("s_title")
    @Expose
    private String sTitle;
    @SerializedName("s_name")
    @Expose
    private String sName;
    @SerializedName("s_img")
    @Expose
    private String sImg;

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getSTitle() {
        return sTitle;
    }

    public void setSTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSImg() {
        return sImg;
    }

    public void setSImg(String sImg) {
        this.sImg = sImg;
    }

}
