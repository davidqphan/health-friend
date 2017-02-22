package com.helpfool.healthfriend;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

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

        addSlide(AppIntroFragment.newInstance("Welcome to Health Friend", "Things Are", R.drawable.health_friend_icon, getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Welcome to Health Friend", "Going According", R.drawable.health_friend_icon, getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Welcome to Health Friend", "To Plan", R.drawable.health_friend_icon, getColor(R.color.colorPrimary)));

        // OPTIONAL METHODS
        // Override bar/separator color.
        //setBarColor(Color.parseColor("#3F51B5"));
        //setSeparatorColor(Color.parseColor("#2196F3"));

        setFadeAnimation();

        // Hide Skip/Done button.
        showSkipButton(true);
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
        finish();
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
