package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saquib.dulhaniyaacom.R;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    SharedPreferences spLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        spLogin = getSharedPreferences("LOGINSP",MODE_PRIVATE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (spLogin.getBoolean("LOGIN_CHECK",false)==true)
                {
                    Intent intent=new Intent(Splash.this,Welcome.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                }
                finish();

            }
        },5000);

        imageView = (ImageView) findViewById(R.id.splash);
        textView = findViewById(R.id.tv_motive);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        textView.startAnimation(animation);

    }
}
