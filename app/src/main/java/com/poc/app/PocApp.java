package com.poc.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.poc.app.dagger.DaggerMainComponent;
import com.poc.app.dagger.MainComponent;


public class PocApp extends Application{

        private MainComponent mainComponent;
        private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.create();
        context = getApplicationContext();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    public static Context getContext() {
        return context;
    }

    @VisibleForTesting
    public void setComponent(MainComponent mainComponent) {
        this.mainComponent = mainComponent;
    }
}
