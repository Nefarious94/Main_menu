package com.example.beentheredonethat;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuizSplashActivity extends QuizActivity {
    private static final String TAG = "Ultima vez";
    private static final String LAST_LAUNCH = "Ultima_vez";
    private AnimatorSet animacion;
    private ObjectAnimator animatorRotation;
    private ObjectAnimator animatorAlpha;
    private ObjectAnimator animatorScale;
    private long animationDuration = 1500;
    private ImageView imagen1, imagen2, imagen3, imagen4;
    private TextView text1, text2, text3;

    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences lastTime = getSharedPreferences(LAST_LAUNCH, MODE_PRIVATE);
        Date now = new Date();
        SimpleDateFormat format =
                new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy");
        if (lastTime.contains("dateTime") == true) {
            //We have recorded the last time we used the game
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(TAG, "Ultima vez: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();
        dateEditor.putString("dateTime",format.format(now));
        dateEditor.commit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        text1 = findViewById(R.id.TextViewTopTitle);
        text2 = findViewById(R.id.TextViewBottomTitle);
        text3 = findViewById(R.id.TextViewBottomVersion);

        text1.setText("Been There");
        text2.setText("Done That!");
        text3.setText("Version 1.0");

        animacion = new AnimatorSet();

        imagen1 = findViewById(R.id.ImageView2_Left);
        imagen2 = findViewById(R.id.ImageView2_Right);
        imagen3 = findViewById(R.id.ImageView3_Left);
        imagen4 = findViewById(R.id.ImageView3_Right);
        animation1();
        animation2();
        animation3();
        animation4();
        handler();
    }

    public void activarDespuesSplash() {
        //startActivity(new Intent(this, DespuesSplash.class));
        startActivity(new Intent(this, QuizMenuActivity.class));
    }

    public void handler(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activarDespuesSplash();
            }
        }, 3000);
    }

    public void animation1(){
        animatorRotation = ObjectAnimator.ofFloat(imagen1, "rotation", -720f);
        animatorRotation.setDuration(animationDuration);
        AnimatorSet animatorSetRotator = new AnimatorSet();
        animatorSetRotator.playTogether(animatorRotation);
        animatorSetRotator.start();
    }
    public void animation2(){
        animatorRotation = ObjectAnimator.ofFloat(imagen2, "rotation", 720f);
        animatorRotation.setDuration(animationDuration);
        AnimatorSet animatorSetRotator = new AnimatorSet();
        animatorSetRotator.playTogether(animatorRotation);
        animatorSetRotator.start();
    }
    public void animation3(){
        animatorAlpha = ObjectAnimator.ofFloat(imagen3, View.ALPHA,0.0f, 1.0f);
        animatorAlpha.setDuration(animationDuration);
        AnimatorSet animatorSetAlpha = new AnimatorSet();
        animatorSetAlpha.playTogether(animatorAlpha);
        animatorSetAlpha.start();
    }
    public void animation4(){
        animatorScale = ObjectAnimator.ofFloat(imagen4, View.SCALE_Y,0.0f,1.0f);
        animatorScale.setDuration(animationDuration);
        AnimatorSet animatorSetAlpha = new AnimatorSet();
        animatorSetAlpha.playTogether(animatorScale);
        animatorSetAlpha.start();
    }
}
