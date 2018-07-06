package com.example.saquib.dulhaniyaacom.bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorPackagesResponse {

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
    @SerializedName("va_value")
    @Expose
    private String vaValue;
    @SerializedName("att_suffix")
    @Expose
    private String attSuffix;

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

    public String getVaValue() {
        return vaValue;
    }

    public void setVaValue(String vaValue) {
        this.vaValue = vaValue;
    }

    public String getAttSuffix() {
        return attSuffix;
    }

    public void setAttSuffix(String attSuffix) {
        this.attSuffix = attSuffix;
    }

}
