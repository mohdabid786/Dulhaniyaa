package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView tv_signup, tv_forgot_pass;
    ImageView iv_fb, iv_google, iv_back;
    EditText email, pass;
    Button login_button;
    TextView terms, privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//        DataBindingUtil.setContentView(this, R.layout.activity_login);

//        getDeviceToken();
        //getpermission();
//        gpsTracker = new GPSTracker(this, this);

        tv_signup = findViewById(R.id.tv_signup);
        tv_forgot_pass = findViewById(R.id.tv_forgot_pass);
        iv_fb = findViewById(R.id.iv_fb);
        iv_google = findViewById(R.id.iv_google);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login_button = findViewById(R.id.login_button);
        iv_back = findViewById(R.id.iv_back);
        terms = findViewById(R.id.terms_and_service);
        privacy = findViewById(R.id.privacy_policy);

        tv_signup.setOnClickListener(this);
        tv_forgot_pass.setOnClickListener(this);
        iv_fb.setOnClickListener(this);
        iv_google.setOnClickListener(this);
        login_button.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        terms.setOnClickListener(this);
        privacy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.tv_signup:
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.tv_forgot_pass:
                Intent intent1 = new Intent(Login.this, Forgot_Password.class);
                startActivity(intent1);
                break;
            case R.id.iv_fb:
                startActivityForResult(new Intent(this, FacebookLogin.class), 121);
                break;
            case R.id.iv_google:
                startActivityForResult(new Intent(this, GoogleLogin.class), 120);
                break;
            case R.id.login_button:
                checkLogin();
//                callLoginApi();
                break;
            case R.id.iv_back:
                onBackPressed();
            case R.id.terms_and_service:
                Intent intent4 = new Intent(this, WebViewActivity.class);
                intent4.putExtra("url", "https://www.dulhaniyaa.com/front/privacy");
                intent4.putExtra("toolText", "Terms of Services");
                startActivity(intent4);
                break;
            case R.id.privacy_policy:
                Intent intent5 = new Intent(this, WebViewActivity.class);
                intent5.putExtra("url", "https://www.dulhaniyaa.com/front/privacy");
                intent5.putExtra("toolText", "Privacy Policy");
                startActivity(intent5);
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String socialMediaType = "";
        if (requestCode == 121) {
            try {
                socialMediaType = "facebook";
                String name = data.getExtras().getString("f_name") + " " + data.getExtras().getString("l_name");
                String f_name = data.getExtras().getString("f_name");
                String l_name = data.getExtras().getString("l_name");
                String fb_id = data.getExtras().getString("socialid");
                String email = data.getExtras().getString("email");
                String image = data.getExtras().getString("image");
                String gender = data.getExtras().getString("gender");

                callSocialLoginApi(name, email, fb_id, image, socialMediaType);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //Toast.makeText(this,"this is facebook login class",Toast.LENGTH_LONG).show();
        } else if (requestCode == 120) {
            socialMediaType = "google";
            String name = data.getExtras().getString("f_name") + " " + data.getExtras().getString("l_name");
            String f_name = data.getExtras().getString("f_name");
            String l_name = data.getExtras().getString("l_name");
            String fb_id = data.getExtras().getString("socialid");
            String email = data.getExtras().getString("email");
            String image = data.getExtras().getString("image");
            String gender = data.getExtras().getString("gender");

            callSocialLoginApi(name, email, fb_id, image, socialMediaType);
            Toast.makeText(Login.this, "this is google login class", Toast.LENGTH_LONG).show();
        }
    }

    private void callSocialLoginApi(String name, String email, String fb_id, String image, String type) {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getSocialLoginResult(name, email, fb_id, image, type,
                "android", SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Login.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
//                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.token, response.body().getSocialLogin().getToken());
                        SharedPreferenceWriter.getInstance(Login.this).writeBooleanValue(SharedPreferenceKey.currentLogin, true);

                        Intent intent = new Intent(Login.this, Welcome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Login.this).hideDialog();
            }
        });
    }

    private void callLoginApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getLoginResult(email.getText().toString(), pass.getText().toString(),
                "android", SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Login.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //   SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.token, response.body().getLogin().getToken());
                        SharedPreferenceWriter.getInstance(Login.this).writeBooleanValue(SharedPreferenceKey.currentLogin, true);
                        //  SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.NOTIFICATION_STATUS,response.body().getLogin().getStatus());
                        //SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.Email,response.body().getLogin().getEmail());
                        Intent intent = new Intent(Login.this, Welcome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Login.this).hideDialog();
            }
        });
    }

    private void checkLogin() {
        boolean flag = true;
        if (email.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Please enter email id", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (pass.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_LONG).show();
            flag = false;
        } else {
            callLoginApi();
        }
    }
}