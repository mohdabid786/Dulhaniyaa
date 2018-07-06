package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
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

import static com.example.saquib.dulhaniyaacom.activities.DulhaniyaaInspiration.fragment;

public class Vendor extends AppCompatActivity {

    public static Object getFragment() {
        return fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendors);

        callVendorApi();
    }




    private void callVendorApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getVendorResult(SharedPreferenceWriter.getInstance(Vendor.this).getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Vendor.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //   SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.token, response.body().getLogin().getToken());
                        SharedPreferenceWriter.getInstance(Vendor.this).writeBooleanValue(SharedPreferenceKey.currentLogin, true);
                        //  SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.NOTIFICATION_STATUS,response.body().getLogin().getStatus());
                        //SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.Email,response.body().getLogin().getEmail());
                        Intent intent = new Intent(Vendor.this, Welcome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Vendor.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Vendor.this).hideDialog();
            }
        });
    }
}