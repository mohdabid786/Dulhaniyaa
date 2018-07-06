package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WallResponse {

    @SerializedName("vp_id")
    @Expose
    private String vpId;
    @SerializedName("vp_img")
    @Expose
    private String vpImg;
    @SerializedName("vp_love")
    @Expose
    private String vpLove;
    @SerializedName("vp_views")
    @Expose
    private String vpViews;
    @SerializedName("ua_id")
    @Expose
    private String uaId;

    public String getVpId() {
        return vpId;
    }

    public void setVpId(String vpId) {
        this.vpId = vpId;
    }

    public String getVpImg() {
        return vpImg;
    }

    public void setVpImg(String vpImg) {
        this.vpImg = vpImg;
    }

    public String getVpLove() {
        return vpLove;
    }

    public void setVpLove(String vpLove) {
        this.vpLove = vpLove;
    }

    public String getVpViews() {
        return vpViews;
    }

    public void setVpViews(String vpViews) {
        this.vpViews = vpViews;
    }

    public String getUaId() {
        return uaId;
    }

    public void setUaId(String uaId) {
        this.uaId = uaId;
    }

}
