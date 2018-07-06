package com.example.saquib.dulhaniyaacom.bean;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealWeddingCollaboratorResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("requestkey")
    @Expose
    private String requestkey;
    @SerializedName("parameter")
    @Expose
    private String parameter;
    @SerializedName("realweddingcollaResponse")
    @Expose
    private List<RealweddingcollaResponse> realweddingcollaResponse = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestkey() {
        return requestkey;
    }

    public void setRequestkey(String requestkey) {
        this.requestkey = requestkey;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public List<RealweddingcollaResponse> getRealweddingcollaResponse() {
        return realweddingcollaResponse;
    }

    public void setRealweddingcollaResponse(List<RealweddingcollaResponse> realweddingcollaResponse) {
        this.realweddingcollaResponse = realweddingcollaResponse;
    }

}
