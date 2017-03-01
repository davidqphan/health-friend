package com.helpfool.healthfriend;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by dphan on 2/21/17.
 */

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        // addSlide(firstFragment);
        // addSlide(secondFragment);
        // addSlide(thirdFragment);

        addSlide(SampleSlide.newInstance(R.layout.intro_fragment_1));
        addSlide(SampleSlide.newInstance(R.layout.intro_fragment_2));
        addSlide(SampleSlide.newInstance(R.layout.intro_fragment_3));

        // OPTIONAL METHODS
        // Override bar/separator color.
        //setBarColor(Color.parseColor("#3F51B5"));
        //setSeparatorColor(Color.parseColor("#2196F3"));

        setFadeAnimation();

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(true);

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        // NOTE: work around, might be a better way of doing this
        SharedPreferences getPrefs =
                PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        // make a new preferences editor
        SharedPreferences.Editor e = getPrefs.edit();

        // edit preference to make it false because we don't want this to run
        e.putBoolean("firstStart", false);

        // apply changes
        e.apply();

        finish();
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

}
