package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorPortfolioResponse {

    @SerializedName("vp_id")
    @Expose
    private String vpId;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("p_id")
    @Expose
    private String pId;
    @SerializedName("vp_img")
    @Expose
    private String vpImg;
    @SerializedName("vp_views")
    @Expose
    private String vpViews;
    @SerializedName("vp_love")
    @Expose
    private String vpLove;
    @SerializedName("vp_created")
    @Expose
    private String vpCreated;
    @SerializedName("vp_modified")
    @Expose
    private String vpModified;

    public String getVpId() {
        return vpId;
    }

    public void setVpId(String vpId) {
        this.vpId = vpId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getVpImg() {
        return vpImg;
    }

    public void setVpImg(String vpImg) {
        this.vpImg = vpImg;
    }

    public String getVpViews() {
        return vpViews;
    }

    public void setVpViews(String vpViews) {
        this.vpViews = vpViews;
    }

    public String getVpLove() {
        return vpLove;
    }

    public void setVpLove(String vpLove) {
        this.vpLove = vpLove;
    }

    public String getVpCreated() {
        return vpCreated;
    }

    public void setVpCreated(String vpCreated) {
        this.vpCreated = vpCreated;
    }

    public String getVpModified() {
        return vpModified;
    }

    public void setVpModified(String vpModified) {
        this.vpModified = vpModified;
    }

}
