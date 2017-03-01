package com.helpfool.healthfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Center action bar text
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        // declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getPrefs =
                        PreferenceManager.getDefaultSharedPreferences(getBaseContext());

                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                if (isFirstStart) {
                    // launch app intro
                    Intent intro_intent = new Intent(MainActivity.this, IntroActivity.class);
                    startActivity(intro_intent);
                }
            }

        });

        t.start();
    }
}
