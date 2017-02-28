package com.helpfool.healthfriend;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by dphan on 2/27/17.
 */

public class ArimaMaduraiTextView extends AppCompatTextView {
    public ArimaMaduraiTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ArimaMaduraiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArimaMaduraiTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "ArimaMadurai-ExtraBold.ttf");
        setTypeface(tf , 3);
    }
}
