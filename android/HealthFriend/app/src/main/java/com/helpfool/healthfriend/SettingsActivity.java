package com.helpfool.healthfriend;

/**
 * Created by joel on 2/22/17.
 */

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Center action bar text
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        TextView activityTitle = (TextView)findViewById(R.id.action_bar_title);
        activityTitle.setText(R.string.settings);

        //Intent intro_intent = new Intent(this, IntroActivity.class);
        //startActivity(intro_intent);

    }
}
