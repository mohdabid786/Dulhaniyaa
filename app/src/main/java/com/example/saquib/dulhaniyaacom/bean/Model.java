package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("m_id")
    @Expose
    private String mId;
    @SerializedName("m_name")
    @Expose
    private String mName;
    @SerializedName("m_slug")
    @Expose
    private String mSlug;
    @SerializedName("m_username")
    @Expose
    private String mUsername;
    @SerializedName("m_password")
    @Expose
    private String mPassword;
    @SerializedName("m_sort")
    @Expose
    private String mSort;
    @SerializedName("m_emailid")
    @Expose
    private String mEmailid;
    @SerializedName("m_phone")
    @Expose
    private String mPhone;
    @SerializedName("m_created")
    @Expose
    private String mCreated;
    @SerializedName("m_lastlogin")
    @Expose
    private Object mLastlogin;
    @SerializedName("m_photo")
    @Expose
    private String mPhoto;
    @SerializedName("m_banner")
    @Expose
    private String mBanner;
    @SerializedName("m_socialmedia")
    @Expose
    private MSocialmedia mSocialmedia;
    @SerializedName("m_detail")
    @Expose
    private MDetail mDetail;

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMSlug() {
        return mSlug;
    }

    public void setMSlug(String mSlug) {
        this.mSlug = mSlug;
    }

    public String getMUsername() {
        return mUsername;
    }

    public void setMUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getMPassword() {
        return mPassword;
    }

    public void setMPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getMSort() {
        return mSort;
    }

    public void setMSort(String mSort) {
        this.mSort = mSort;
    }

    public String getMEmailid() {
        return mEmailid;
    }

    public void setMEmailid(String mEmailid) {
        this.mEmailid = mEmailid;
    }

    public String getMPhone() {
        return mPhone;
    }

    public void setMPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getMCreated() {
        return mCreated;
    }

    public void setMCreated(String mCreated) {
        this.mCreated = mCreated;
    }

    public Object getMLastlogin() {
        return mLastlogin;
    }

    public void setMLastlogin(Object mLastlogin) {
        this.mLastlogin = mLastlogin;
    }

    public String getMPhoto() {
        return mPhoto;
    }

    public void setMPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

    public String getMBanner() {
        return mBanner;
    }

    public void setMBanner(String mBanner) {
        this.mBanner = mBanner;
    }

    public MSocialmedia getMSocialmedia() {
        return mSocialmedia;
    }

    public void setMSocialmedia(MSocialmedia mSocialmedia) {
        this.mSocialmedia = mSocialmedia;
    }

    public MDetail getMDetail() {
        return mDetail;
    }

    public void setMDetail(MDetail mDetail) {
        this.mDetail = mDetail;
    }

}
