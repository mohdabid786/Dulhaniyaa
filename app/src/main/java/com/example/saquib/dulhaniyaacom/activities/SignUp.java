package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    TextView tv_loginagain, tv_signup_as_vendor, terms_and_service, privacy_policy;
    ImageView iv_back, iv_fb, iv_google;
    Button btn_signup;
    EditText name, email, password, phone;
    RadioGroup radioGroup;
    RadioButton gender;
    String genderposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        DataBindingUtil.setContentView(this,R.layout.activity_sign_up);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);

        iv_back= findViewById(R.id.iv_back);
        iv_fb = findViewById(R.id.iv_fb);
        iv_google = findViewById(R.id.iv_google);

        btn_signup = findViewById(R.id.btn_signup);
        tv_loginagain = findViewById(R.id.tv_loginagain);
        tv_signup_as_vendor = findViewById(R.id.tv_signup_as_vendor);

        terms_and_service = findViewById(R.id.terms_and_service);
        privacy_policy = findViewById(R.id.privacy_policy);
        radioGroup = findViewById(R.id.radioGroup);

//        radioGroup = findViewById(R.id.radioGroup);

        btn_signup.setOnClickListener(this);
        tv_loginagain.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_fb.setOnClickListener(this);
        iv_google.setOnClickListener(this);
        terms_and_service.setOnClickListener(this);
        privacy_policy.setOnClickListener(this);
        tv_signup_as_vendor.setOnClickListener(this);

//        setUpMapData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_signup:
                addListenerOnButton();
                checkSignup();
                break;
            case R.id.tv_loginagain:
                Intent intent1 = new Intent(SignUp.this, Login.class);
                startActivity(intent1);
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_fb:
                startActivityForResult(new Intent(this, FacebookLogin.class), 121);
                break;
            case R.id.iv_google:
                startActivityForResult(new Intent(this, GoogleLogin.class), 120);
                break;
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

    private void callchkUserApi()
    {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getcheckUserResult(phone.getText().toString(),email.getText().toString());

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful())
                {
                    Toast.makeText(SignUp.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                    if (response.body().getStatus().equals("SUCCESS")) {
                        callVerificationCodeApi();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }
        });
    }

    private void callVerificationCodeApi()
    {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getverificationCodeResult(phone.getText().toString());

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful())
                {
//                    Toast.makeText(SignUp.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                    if (response.body().getStatus().equals("SUCCESS")) {
                        SharedPreferenceWriter.getInstance(SignUp.this).writeStringValue(SharedPreferenceKey.token, response.body().getSignup().getToken());
                        Intent intent = new Intent(SignUp.this, OTP.class);
                        intent.putExtra("verification",response.body().getVerificationCode());
                        intent.putExtra("name",name.getText().toString());
                        intent.putExtra("email",email.getText().toString());
                        intent.putExtra("phone",phone.getText().toString());
                        intent.putExtra("password",password.getText().toString());
                        intent.putExtra("gender",gender.getText().toString());
                        startActivity(intent);
//                        Toast.makeText(SignUp.this,response.body().getVerificationCode(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }
        });
    }

    private Map<String,RequestBody> setUpMapData() {
        Map<String,RequestBody> fields = new HashMap<>();
        RequestBody user_name = RequestBody.create(MediaType.parse("text/plain"), name.getText().toString());
        RequestBody phone_no = RequestBody.create(MediaType.parse("text/plain"), phone.getText().toString() );
        RequestBody email_id = RequestBody.create(MediaType.parse("text/plain"), email.getText().toString());
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), password.getText().toString());
        RequestBody radio = RequestBody.create(MediaType.parse("text/plain"), gender.getText().toString());
        RequestBody devicetoken = RequestBody.create(MediaType.parse("text/plain"), SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_token));
        RequestBody devicetype = RequestBody.create(MediaType.parse("text/plain"), "android");
        fields.put("device_token", devicetoken);
        fields.put("device_type", devicetype);
        fields.put("phone", phone_no);
        fields.put("email", email_id);
        fields.put("password", pass);
        fields.put("name",user_name);
        fields.put("gender",radio);

        return fields;
    }

    public void addListenerOnButton() {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                gender = findViewById(selectedId);

                if(selectedId==-1){
                    Toast.makeText(this, "please select gender", Toast.LENGTH_SHORT).show();
                }else{
                  //  Toast.makeText(SignUp.this,gender.getText(), Toast.LENGTH_SHORT).show();
                    genderposition= (String) gender.getText();
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
            Toast.makeText(SignUp.this,"this is google login class",Toast.LENGTH_LONG).show();
        }
    }

    private void callSocialLoginApi(String name, String email, String fb_id, String image,String type) {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getSocialLoginResult(name,email,fb_id,image,type,
                "android", SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
//                        SharedPreferenceWriter.getInstance(SignUp.this).writeStringValue(SharedPreferenceKey.token, response.body().getSocialLogin().getToken());
                        SharedPreferenceWriter.getInstance(SignUp.this).writeBooleanValue(SharedPreferenceKey.currentLogin,true);

                        Intent intent = new Intent(SignUp.this, DulhaniyaaInspiration.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignUp.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }
        });
    }

    void checkSignup()
    {
        boolean flag=true;
        if (name.getText().toString().equals("")) {
            Toast.makeText(SignUp.this, "Please enter name", Toast.LENGTH_LONG).show();
            flag = false;
        }else if (email.getText().toString().equals("")) {
            Toast.makeText(SignUp.this,"Please enter e-mail address",Toast.LENGTH_LONG).show();
            flag=false;
        }else if (password.getText().toString().equals("")) {
            Toast.makeText(SignUp.this,"Please enter password",Toast.LENGTH_LONG).show();
            flag=false;
        }else if (phone.getText().toString().equals("")) {
            Toast.makeText(SignUp.this,"Please enter phone number",Toast.LENGTH_LONG).show();
            flag=false;
        }else if (genderposition.equals("")) {
            Toast.makeText(SignUp.this,"Please select gender",Toast.LENGTH_LONG).show();
            flag=false;
        }else{
            callchkUserApi();
        }
    }
}