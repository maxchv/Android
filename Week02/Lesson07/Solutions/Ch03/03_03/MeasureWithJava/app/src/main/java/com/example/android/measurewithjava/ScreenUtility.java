package com.example.android.measurewithjava;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {

    float dpWidth;
    float dpHeight;

    public ScreenUtility(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = activity.getResources().getDisplayMetrics().density;

        dpWidth = outMetrics.widthPixels / density;
        dpHeight = outMetrics.heightPixels / density;
    }

    public float getDpWidth() {
        return dpWidth;
    }

    public float getDpHeight() {
        return dpHeight;
    }

}
