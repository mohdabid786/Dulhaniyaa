package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Forgot_Password extends AppCompatActivity implements View.OnClickListener {

    TextView tv_cancel;
    Button send_button;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        tv_cancel = findViewById(R.id.tv_cancel);
        send_button = findViewById(R.id.send_button);
        email = findViewById(R.id.email);

        tv_cancel.setOnClickListener(this);
        send_button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_cancel:
                onBackPressed();
                break;

            case R.id.send_button:
                if (email.getText().toString().equals(""))
                {
                    Toast.makeText(this,"Please enter email id",Toast.LENGTH_LONG).show();
                }else
                    callForgotPasswordApi();
                break;
        }
    }

    private void callForgotPasswordApi()
    {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getForgotResult(email.getText().toString());

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Forgot_Password.this).hideDialog();
                if (response.isSuccessful())
                {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        startActivity(new Intent(Forgot_Password.this,ResetPassword.class));
                    }else
                    {
                        Toast.makeText(Forgot_Password.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Forgot_Password.this).hideDialog();
            }
        });
    }
}

