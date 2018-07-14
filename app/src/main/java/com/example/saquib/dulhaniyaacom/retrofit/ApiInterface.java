package com.example.saquib.dulhaniyaacom.retrofit;

import com.example.saquib.dulhaniyaacom.bean.CommonResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.Call;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("signup")
    Call<CommonResponse> getSingupResult(@Field("name") String name,
                                         @Field("email") String email,
                                         @Field("phone") String phone,
                                         @Field("password") String pass,
                                         @Field("gender") String gender,
                                         @Field("device_type") String device_type,
                                         @Field("device_token") String device_token);

    @FormUrlEncoded
    @POST("checkUser")
    Call<CommonResponse> getcheckUserResult(@Field("phone") String phone,
                                            @Field("email") String email);

    @FormUrlEncoded
    @POST("verificationCode")
    Call<CommonResponse> getverificationCodeResult(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("sendotp")
    Call<CommonResponse> getSendotp(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("changePassword")
    Call<CommonResponse> getChangePasswordResult(@Field("token") String token,
                                                 @Field("password") String newPassword);

    @FormUrlEncoded
    @POST("login")
    Call<CommonResponse> getLoginResult(@Field("email") String email,
                                        @Field("password") String pasword,
                                        @Field("device_type") String device_type,
                                        @Field("device_token") String device_token);

    @FormUrlEncoded
    @POST("socialLogin")
    Call<CommonResponse> getSocialLoginResult(@Field("name") String name,
                                              @Field("email") String email,
                                              @Field("social_id") String social_id,
                                              @Field("image") String image,
                                              @Field("type") String fbOrgoogle,
                                              @Field("device_type") String device_type,
                                              @Field("device_token") String device_token);

    @FormUrlEncoded
    @POST("forgotPassword")
    Call<CommonResponse> getForgotResult(@Field("email") String email);

    @FormUrlEncoded
    @POST("resetPassword")
    Call<CommonResponse> getResetPasswordResult(@Field("otp") String token,
                                                @Field("newPassword") String newPassword,
                                                @Field("cnfPassword") String cnfPassword);

    @FormUrlEncoded
    @POST("logout")
    Call<CommonResponse> getLogoutResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("profileData")
    Call<CommonResponse> getProfileDataResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("updateProfile")
    Call<CommonResponse> getUpdateProfile(@Field("token") String token,
                                          @Field("gender") String gender,
                                          @Field("phone") String phone,
                                          @Field("image") String image,
                                          @Field("name") String name,
                                          @Field("password") String password);

    @FormUrlEncoded
    @POST("blog")
    Call<CommonResponse> getBlogResult(@Field("blog_id") String blog_id);

    @FormUrlEncoded
    @POST("myFavourites")
    Call<CommonResponse> getMyFavouriteResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("favourite")
    Call<CommonResponse> getFavouriteResult(@Field("token") String token);

    @FormUrlEncoded
    @POST("get_inspirational")
    Call<CommonResponse> getInspirationResult(@Field("vp_img") String vp_img,
                                              @Field("vp_id") String vp_id,
                                              @Field("vp_love") String vp_love,
                                              @Field("vp_views") String vp_views);

    @FormUrlEncoded
    @POST("notification")
    Call<CommonResponse> getNotification(@Field("token") String token);

    @FormUrlEncoded
    @GET("get_all_cateogry")
    Call<CommonResponse> getVendorResult(String string);

    @FormUrlEncoded
    @POST("realWedding")
    Call<CommonResponse> getRealWeddingResult(@Field("token") String token);

    Call<CommonResponse> getContactResult(String string, String user, String s, String s1);

    Call<CommonResponse> getProfileResult(Map<String, RequestBody> map, MultipartBody.Part profilePart);
}
