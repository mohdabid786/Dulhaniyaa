package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditReviewResponse {

    @SerializedName("vr_id")
    @Expose
    private String vrId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("vr_rating")
    @Expose
    private String vrRating;
    @SerializedName("vr_reviews")
    @Expose
    private String vrReviews;
    @SerializedName("vr_date")
    @Expose
    private String vrDate;

    public String getVrId() {
        return vrId;
    }

    public void setVrId(String vrId) {
        this.vrId = vrId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVrRating() {
        return vrRating;
    }

    public void setVrRating(String vrRating) {
        this.vrRating = vrRating;
    }

    public String getVrReviews() {
        return vrReviews;
    }

    public void setVrReviews(String vrReviews) {
        this.vrReviews = vrReviews;
    }

    public String getVrDate() {
        return vrDate;
    }

    public void setVrDate(String vrDate) {
        this.vrDate = vrDate;
    }

}
