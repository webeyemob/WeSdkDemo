package com.wesdk.demo;

import android.app.Application;

import com.we.sdk.core.api.WeSdk;
import com.we.sdk.core.api.WeSdkConfiguration;

public class DemoApplication extends Application {

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
