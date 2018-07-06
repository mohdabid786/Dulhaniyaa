package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealweddingcollaResponse {

    @SerializedName("rwg_id")
    @Expose
    private String rwgId;
    @SerializedName("rw_id")
    @Expose
    private String rwId;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("rwg_about")
    @Expose
    private String rwgAbout;
    @SerializedName("vendor_id")
    @Expose
    private Object vendorId;
    @SerializedName("other_vendors")
    @Expose
    private String otherVendors;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("cat_slug")
    @Expose
    private String catSlug;
    @SerializedName("cat_banner")
    @Expose
    private String catBanner;
    @SerializedName("cat_icon")
    @Expose
    private String catIcon;
    @SerializedName("subcat_icon")
    @Expose
    private Object subcatIcon;
    @SerializedName("subcat_label")
    @Expose
    private String subcatLabel;
    @SerializedName("budget_icon")
    @Expose
    private Object budgetIcon;
    @SerializedName("budget_label")
    @Expose
    private String budgetLabel;
    @SerializedName("vendor")
    @Expose
    private Object vendor;
    @SerializedName("other_vendorsss")
    @Expose
    private String otherVendorsss;

    public String getRwgId() {
        return rwgId;
    }

    public void setRwgId(String rwgId) {
        this.rwgId = rwgId;
    }

    public String getRwId() {
        return rwId;
    }

    public void setRwId(String rwId) {
        this.rwId = rwId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getRwgAbout() {
        return rwgAbout;
    }

    public void setRwgAbout(String rwgAbout) {
        this.rwgAbout = rwgAbout;
    }

    public Object getVendorId() {
        return vendorId;
    }

    public void setVendorId(Object vendorId) {
        this.vendorId = vendorId;
    }

    public String getOtherVendors() {
        return otherVendors;
    }

    public void setOtherVendors(String otherVendors) {
        this.otherVendors = otherVendors;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatSlug() {
        return catSlug;
    }

    public void setCatSlug(String catSlug) {
        this.catSlug = catSlug;
    }

    public String getCatBanner() {
        return catBanner;
    }

    public void setCatBanner(String catBanner) {
        this.catBanner = catBanner;
    }

    public String getCatIcon() {
        return catIcon;
    }

    public void setCatIcon(String catIcon) {
        this.catIcon = catIcon;
    }

    public Object getSubcatIcon() {
        return subcatIcon;
    }

    public void setSubcatIcon(Object subcatIcon) {
        this.subcatIcon = subcatIcon;
    }

    public String getSubcatLabel() {
        return subcatLabel;
    }

    public void setSubcatLabel(String subcatLabel) {
        this.subcatLabel = subcatLabel;
    }

    public Object getBudgetIcon() {
        return budgetIcon;
    }

    public void setBudgetIcon(Object budgetIcon) {
        this.budgetIcon = budgetIcon;
    }

    public String getBudgetLabel() {
        return budgetLabel;
    }

    public void setBudgetLabel(String budgetLabel) {
        this.budgetLabel = budgetLabel;
    }

    public Object getVendor() {
        return vendor;
    }

    public void setVendor(Object vendor) {
        this.vendor = vendor;
    }

    public String getOtherVendorsss() {
        return otherVendorsss;
    }

    public void setOtherVendorsss(String otherVendorsss) {
        this.otherVendorsss = otherVendorsss;
    }

}
