package com.deanxd.taxiform.ui;

import android.annotation.SuppressLint;
import android.app.Application;

/**
 * Created by think on 2018/9/24.
 */

public class MyApplication extends Application {

    private static MyApplication INSTANCE;


    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static MyApplication getContext() {
        return INSTANCE;
    }

}
