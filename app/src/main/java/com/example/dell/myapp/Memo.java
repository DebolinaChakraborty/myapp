package com.example.dell.myapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by DELL on 6/10/2016.
 */
public class Memo extends Application {
    private static Context mContext;
    public static String currentServerDate;

    @Override public void onCreate() {
        super.onCreate();
//        mContext = getApplicationContext();
    }
    public static Context getContext() { return mContext; }
    public static void setContext(Context context) { mContext = context; }

}
