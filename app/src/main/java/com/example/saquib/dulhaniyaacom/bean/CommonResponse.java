package com.example.saquib.dulhaniyaacom.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommonResponse {

    @SerializedName("status")
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("message")
    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("requestKey")
    private String requestKey;
    public String getRequestKey() {
        return requestKey;
    }
    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    @SerializedName("text")
    private String text = "";
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @SerializedName("sendotp")
    private String sendotp;
    public String getSendotp() {
        return sendotp;
    }
    public void setSendotp(String sendotp) {
        this.sendotp = sendotp;
    }

    @SerializedName("signup")
    private SignupResponse signup;
    public SignupResponse getSignup() {
        return signup;
    }
    public void setSignup(SignupResponse signup) {
        this.signup = signup;
    }

    @SerializedName("login")
    private LoginResponse login;
    public LoginResponse getLogin() {
        return login;
    }
    public void setLogin(LoginResponse login) {
        this.login = login;
    }

    @SerializedName("socialLogin")
    private SocialLoginResponse socialLogin;
    public SocialLoginResponse getSocialLogin() {
        return socialLogin;
    }

    public void setSocialLogin(SocialLoginResponse socialLogin) {
        this.socialLogin = socialLogin;
    }

    @SerializedName("verificationCode")
    private String verificationCode;
    public String getVerificationCode() {
        return verificationCode;
    }
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @SerializedName("profile")
    private ProfileResponse profile;
    public ProfileResponse getProfile() {
        return profile;
    }
    public void setProfile(ProfileResponse profile) {
        this.profile = profile;
    }

    @SerializedName("myFavourites")
    private List<MyFavouriteResponse> myFavourites;
    public List<MyFavouriteResponse> getMyFavourites() {
        return myFavourites;
    }
    public void setMyFavourites(List<MyFavouriteResponse> myFavourites) {
        this.myFavourites = myFavourites;
    }

    @SerializedName("favourite")
    private FavouriteResponse favourite;
    public FavouriteResponse getFavourite() {
        return favourite;
    }
    public void setFavourite(FavouriteResponse favourite) {
        this.favourite = favourite;
    }

    @SerializedName("notification")
    private List<NotificationResponse> notification;
    public List<NotificationResponse> getNotification() {
        return notification;
    }
    public void setNotification(List<NotificationResponse> notification) {
        this.notification = notification;
    }

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

    @SerializedName("blog")
    private List<BlogResponse> blog;
    public  List<BlogResponse> getBlog() {
        return blog;
    }

    @SerializedName("maincat")
    @Expose
    private List<Maincat> maincat = null;

    public List<Maincat> getMaincat() {
        return maincat;
    }

    public void setMaincat(List<Maincat> maincat) {
        this.maincat = maincat;
    }

}

