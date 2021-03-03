package com.alitv.alitvshows.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.alitv.alitvshows.R;
import com.alitv.alitvshows.activity.LoginActivity;
import com.bumptech.glide.Glide;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView animasi =  findViewById(R.id.iv_logo);
        Glide.with(this).load(R.drawable.loading).into(animasi);
        final Handler handler = new Handler();
        handler.postDelayed(()->{
            startActivity(new Intent(this, LoginActivity.class));
        }, 5000);
    }
}