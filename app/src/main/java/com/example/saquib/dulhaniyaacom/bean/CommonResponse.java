package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommonResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("requestKey")
    private String requestKey;

    @SerializedName("text")
    private String text = "";

    @SerializedName("sendotp")
    private String sendotp;

    @SerializedName("signup")
    private SignupResponse signup;

    @SerializedName("login")
    private LoginResponse login;

    @SerializedName("socialLogin")
    private SocialLoginResponse socialLogin;

    @SerializedName("verificationCode")
    private String verificationCode;

//    @SerializedName("verificationCode")
//    List<SignupResponse> verificationCode;

    @SerializedName("profile")
    private ProfileResponse profile;

    @SerializedName("myFavourites")
    private List<MyFavouriteResponse> myFavourites;

    @SerializedName("favourite")
    private FavouriteResponse favourite;

    @SerializedName("notification")
    private List<NotificationResponse> notification;


    @SerializedName("realWedding")
    private List<RealWeddingResponse> realwedding;

    public List<RealWeddingResponse> getRealwedding() {
        return realwedding;
    }

    public void setRealwedding(List<RealWeddingResponse> realwedding) {
        this.realwedding = realwedding;
    }

    @SerializedName("get_inspirational")
    private List<PhotosResponse> get_inspirational;

    public List<PhotosResponse> getGet_inspirational() {
        return get_inspirational;
    }

    public void setGet_inspirational(List<PhotosResponse> get_inspirational) {
        this.get_inspirational = get_inspirational;
    }





    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

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

    public String getRequestKey() {
        return requestKey;
    }
    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public String getSendotp() {
        return sendotp;
    }
    public void setSendotp(String sendotp) {
        this.sendotp = sendotp;
    }

    public LoginResponse getLogin() {
        return login;
    }
    public void setLogin(LoginResponse login) {
        this.login = login;
    }

    public SocialLoginResponse getSocialLogin() {
        return socialLogin;
    }
    public void setSocialLogin(SocialLoginResponse socialLogin) {
        this.socialLogin = socialLogin;
    }

    public ProfileResponse getProfile() {
        return profile;
    }
    public void setProfile(ProfileResponse profile) {
        this.profile = profile;
    }

    public SignupResponse getSignup() {
        return signup;
    }
    public void setSignup(SignupResponse signup) {
        this.signup = signup;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public FavouriteResponse getFavourite() {
        return favourite;
    }
    public void setFavourite(FavouriteResponse favourite) {
        this.favourite = favourite;
    }

    public List<MyFavouriteResponse> getMyFavourites() {
        return myFavourites;
    }

    public void setMyFavourites(List<MyFavouriteResponse> myFavourites) {
        this.myFavourites = myFavourites;
    }

    public List<NotificationResponse> getNotification() {
        return notification;
    }
    public void setNotification(List<NotificationResponse> notification) {
        this.notification = notification;
    }

    @SerializedName("blog")
    private List<BlogResponse> blog;
    public  List<BlogResponse> getBlog() {
        return blog;
    }

//    @SerializedName("vendor")
//    private List<VendorResponse> vendor;
//
//    public List<VendorResponse> getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(List<VendorResponse> vendor) {
//        this.vendor = vendor;
//    }

    @SerializedName("vendor")
    @Expose
    private List<VendorResponse> maincat = null;

    public List<VendorResponse> getMaincat() {
        return maincat;
    }

    public void setMaincat(List<VendorResponse> maincat) {
        this.maincat = maincat;
    }

}

