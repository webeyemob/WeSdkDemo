package com.wesdk.demo.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.we.sdk.core.api.WeSdk;
import com.we.sdk.core.api.WeSdkConfiguration;

public class DemoApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Set GDPR
        WeSdk.getDefault().setGdprConsent(true);

        // Show Log
        WeSdk.setLogEnable(true);

        // Init With AppId
        WeSdkConfiguration configuration = new WeSdkConfiguration.Builder(this)
                .appId("27ba06dc-f393-41b2-983e-a3cf6a6bb3b3")
                .build();
        WeSdk.getDefault().initialize(this, configuration);
    }
}
