package com.example.minipetworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//
//        SystemClock.sleep(500);
//        Intent RegisterIntent = new Intent(SplashActivity.this, RegisterActivity.class);
//        startActivity(RegisterIntent);
//finish();

//        getSupportActionBar().hide();
        Thread thread =new Thread(){
          public void run(){
              try {
                sleep(3000);
              }catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  Intent RegisterIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                  startActivity(RegisterIntent);

              }
          }
        };thread.start();

    }

}