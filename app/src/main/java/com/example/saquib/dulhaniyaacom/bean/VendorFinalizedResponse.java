package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorFinalizedResponse {

    @SerializedName("vf_id")
    @Expose
    private String vfId;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("date_final")
    @Expose
    private String dateFinal;

    public String getVfId() {
        return vfId;
    }

    public void setVfId(String vfId) {
        this.vfId = vfId;
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

    public String getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(String dateFinal) {
        this.dateFinal = dateFinal;
    }

}
