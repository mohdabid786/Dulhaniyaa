package com.example.saquib.dulhaniyaacom.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.adapter.NotificationAdapter;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.bean.NotificationResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
import com.example.saquib.dulhaniyaacom.util.BeanClass;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Notification extends AppCompatActivity {

    private Toolbar myToolbar;
    TextView tv_title;
    RecyclerView rv_noti;
    ArrayList<BeanClass> noti= new ArrayList<BeanClass>();
    BeanClass beanClass= new BeanClass();
    NotificationAdapter notAdap;
    List<NotificationResponse> notificationResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        All();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_noti.setLayoutManager(linearLayoutManager);

        callNotificationApi();
    }

    private void callNotificationApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getNotification(SharedPreferenceWriter.getInstance(Notification.this).getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Notification.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        notificationResponseList=response.body().getNotification();

                        notAdap = new NotificationAdapter(Notification.this, notificationResponseList);
                        rv_noti.setAdapter(notAdap);

                    } else {
                        Toast.makeText(Notification.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Notification.this).hideDialog();
            }
        });
    }

    private void All(){

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setVisibility(View.VISIBLE);
        tv_title.setText("Notification");

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        rv_noti = (RecyclerView)findViewById(R.id.rv_noti);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        myToolbar.setNavigationIcon(R.drawable.back);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });


    }

}
