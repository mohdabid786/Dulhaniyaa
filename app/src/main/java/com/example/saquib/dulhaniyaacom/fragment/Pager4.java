package com.example.saquib.dulhaniyaacom.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.activities.DulhaniyaaInspiration;
import com.example.saquib.dulhaniyaacom.activities.FacebookLogin;
import com.example.saquib.dulhaniyaacom.activities.GoogleLogin;
import com.example.saquib.dulhaniyaacom.activities.MyWedding;
import com.example.saquib.dulhaniyaacom.activities.VendorDescription;
import com.example.saquib.dulhaniyaacom.activities.VendorMain;
import com.example.saquib.dulhaniyaacom.activities.Welcome;
import com.example.saquib.dulhaniyaacom.activities.Login;
import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.activities.SignUp;
import com.example.saquib.dulhaniyaacom.activities.WebViewActivity;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Pager4 extends Fragment {

    ImageView iv_fb, iv_google;
    Button sign_up, login;
    TextView skip_for_now, terms_and_service, privacy_policy;

    public Pager4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pager4,
                container, false);

        iv_fb = view.findViewById(R.id.iv_fb);
        iv_google = view.findViewById(R.id.iv_google);
        login = view.findViewById(R.id.btn_login);
        sign_up = view.findViewById(R.id.btn_signup);
        skip_for_now =  view.findViewById(R.id.skip_for_now);
        terms_and_service = view.findViewById(R.id.terms_and_service);
        privacy_policy = view.findViewById(R.id.privacy_policy);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUp.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });

        iv_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), FacebookLogin.class), 121);
            }
        });

        iv_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), GoogleLogin.class), 120);
            }
        });

        skip_for_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VendorMain.class);
                startActivity(intent);
            }
        });

        terms_and_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), WebViewActivity.class);
                intent4.putExtra("url", "https://www.dulhaniyaa.com/front/privacy");
                intent4.putExtra("toolText", "Terms of Services");
                startActivity(intent4);
            }
        });

        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getActivity(), WebViewActivity.class);
                intent5.putExtra("url", "https://www.dulhaniyaa.com/front/privacy");
                intent5.putExtra("toolText", "Privacy Policy");
                startActivity(intent5);

            }
        });

        return view;

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
            Toast.makeText(getActivity(),"this is google login class",Toast.LENGTH_LONG).show();
        }
    }

    private void callSocialLoginApi(String name, String email, String fb_id, String image,String type) {
        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getSocialLoginResult(name,email,fb_id,image,type,
                "android", SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.device_token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
//                        SharedPreferenceWriter.getInstance(getActivity()).writeStringValue(SharedPreferenceKey.token, response.body().getSocialLogin().getToken());
                        SharedPreferenceWriter.getInstance(getActivity()).writeBooleanValue(SharedPreferenceKey.currentLogin,true);

                        Intent intent = new Intent(getActivity(), DulhaniyaaInspiration.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }
}
