package com.example.beentheredonethat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class QuizMenuActivity extends QuizActivity {
    TextView title;
    ListView menuList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        title = findViewById(R.id.Title_Menu);
        title.setText("Main Menu");
        menuList = findViewById(R.id.ListView_Menu);
        final String[] items = getResources().getStringArray(R.array.menu_array);

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                R.layout.menu_item, items);
        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View itemClicked,
                                    int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(items[0])) {
// Launch the Game Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizGameActivity.class));

                } else if (strText.equalsIgnoreCase(items[3])) {
// Launch the Help Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizHelpActivity.class));
                } else if (strText.equalsIgnoreCase(items[2])) {
// Launch the Settings Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizSettingsActivity.class));
                } else if (strText.equalsIgnoreCase(items[1])) {
// Launch the Scores Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizScoresActivity.class));
                }
            }
        });
    }
}
