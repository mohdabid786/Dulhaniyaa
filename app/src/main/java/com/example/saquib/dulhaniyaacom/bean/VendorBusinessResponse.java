package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorBusinessResponse {

    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("business_name")
    @Expose
    private String businessName;
    @SerializedName("vp_img")
    @Expose
    private String vpImg;
    @SerializedName("contact_person")
    @Expose
    private String contactPerson;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("contact_phone")
    @Expose
    private String contactPhone;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("state_name")
    @Expose
    private String stateName;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getVpImg() {
        return vpImg;
    }

    public void setVpImg(String vpImg) {
        this.vpImg = vpImg;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}
