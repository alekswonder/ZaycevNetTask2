package com.example.zaycevnettask2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String START_COUNTER = "startCounter";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        sharedPreferences = getSharedPreferences(START_COUNTER, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        count = sharedPreferences.getInt("count", count);
        count++;
        editor.putInt("count", count);
        editor.commit();
        String line = String.format(getString(R.string.result_value)
                , sharedPreferences.getInt("count", -1));
        if (sharedPreferences.getInt("count", -1) >= 3) {
            Toast.makeText(this, line,
                    Toast.LENGTH_SHORT).show();
        }
    }
}