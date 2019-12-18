package com.example.beentheredonethat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

public class QuizActivity extends AppCompatActivity {
    public static final String GAME_PREFERENCES = "GamePrefs";

    private void displaySharedPreferences() {
        SharedPreferences settings =
                getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("UserName", "Sergi");
        prefEditor.putInt("UserAge", 25);
        prefEditor.commit();
    }
}
