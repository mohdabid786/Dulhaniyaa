package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorFeaturesResponse {

    @SerializedName("att_id")
    @Expose
    private String attId;
    @SerializedName("att_name_user")
    @Expose
    private String attNameUser;
    @SerializedName("att_prefix")
    @Expose
    private String attPrefix;
    @SerializedName("att_icon")
    @Expose
    private String attIcon;
    @SerializedName("att_suffix")
    @Expose
    private String attSuffix;
    @SerializedName("cao_id")
    @Expose
    private String caoId;
    @SerializedName("cao_name_user")
    @Expose
    private String caoNameUser;

    public String getAttId() {
        return attId;
    }

    public void setAttId(String attId) {
        this.attId = attId;
    }

    public String getAttNameUser() {
        return attNameUser;
    }

    public void setAttNameUser(String attNameUser) {
        this.attNameUser = attNameUser;
    }

    public String getAttPrefix() {
        return attPrefix;
    }

    public void setAttPrefix(String attPrefix) {
        this.attPrefix = attPrefix;
    }

    public String getAttIcon() {
        return attIcon;
    }

    public void setAttIcon(String attIcon) {
        this.attIcon = attIcon;
    }

    public String getAttSuffix() {
        return attSuffix;
    }

    public void setAttSuffix(String attSuffix) {
        this.attSuffix = attSuffix;
    }

    public String getCaoId() {
        return caoId;
    }

    public void setCaoId(String caoId) {
        this.caoId = caoId;
    }

    public String getCaoNameUser() {
        return caoNameUser;
    }

    public void setCaoNameUser(String caoNameUser) {
        this.caoNameUser = caoNameUser;
    }

}
