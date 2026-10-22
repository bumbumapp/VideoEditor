package com.bumbumapps.videoeditor;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.google.firebase.crashlytics.FirebaseCrashlytics;


public class VideoApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        EdgeToEdgeInsets.install(this);
    }

}
