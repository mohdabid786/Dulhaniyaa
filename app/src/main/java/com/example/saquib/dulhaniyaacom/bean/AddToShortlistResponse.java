package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddToShortlistResponse {

    @SerializedName("vsh_id")
    @Expose
    private String vshId;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("vsh_date")
    @Expose
    private String vshDate;

    public String getVshId() {
        return vshId;
    }

    public void setVshId(String vshId) {
        this.vshId = vshId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVshDate() {
        return vshDate;
    }

    public void setVshDate(String vshDate) {
        this.vshDate = vshDate;
    }

}
