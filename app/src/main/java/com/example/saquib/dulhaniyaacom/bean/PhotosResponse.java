package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhotosResponse implements Serializable {

    @SerializedName("vp_id")
    private String vp_id;

    @SerializedName("vendor_id")
    private String vendor_id;

    @SerializedName("p_id")
    private String p_id;

    @SerializedName("vp_img")
    private String vp_img;

    @SerializedName("vp_views")
    private String vp_views;

    @SerializedName("vp_love")
    private String vp_love;

    @SerializedName("vp_created")
    private String vp_created;

    @SerializedName("vp_modified")
    private String vp_modified;

    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVp_id() {
        return vp_id;
    }

    public void setVp_id(String vp_id) {
        this.vp_id = vp_id;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getVp_img() {
        return vp_img;
    }

    public void setVp_img(String rest_image) {
        this.vp_img = vp_img;
    }

    public String getVp_views() {
        return vp_views;
    }

    public void setVp_views(String vp_views) {
        this.vp_views = vp_views;
    }

    public String getVp_love() {
        return vp_love;
    }

    public void setVp_love(String vp_love) {
        this.vp_love = vp_love;
    }

    public String getVp_created() {
        return vp_created;
    }

    public void setVp_created(String vp_created) {
        this.vp_created = vp_created;
    }

    public String getVp_modified() {
        return vp_modified;
    }

    public void setVp_modified(String vp_modified) {
        this.vp_modified = vp_modified;
    }

}
