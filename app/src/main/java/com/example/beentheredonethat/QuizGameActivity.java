package com.example.beentheredonethat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizGameActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }
}
