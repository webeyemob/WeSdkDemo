package com.wesdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.we.sdk.core.api.ad.mixfull.MixFullScreenAd;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;

public class MixFullScreenActivity extends Activity {

    private final String TAG = "MixFullScreenActivity";

    private Button mLoadButton;
    private Button mShowButton;

    private MixFullScreenAd mMixFullScreenAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixfullscreen);

        mLoadButton = findViewById(R.id.mixfullscreen_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load MixFullScreenAd
                mMixFullScreenAd.loadAd();
            }
        });

        mShowButton = findViewById(R.id.mixfullscreen_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Show MixFullScreenAd
                mMixFullScreenAd.show();
            }
        });

        initMixFullScreenAd();
    }

    private void initMixFullScreenAd() {
        mMixFullScreenAd = new MixFullScreenAd(this);
        // Set AdUnitId
        mMixFullScreenAd.setAdUnitId("6a721d64-be26-4f62-9b38-1a63456ac2bc");
        // Set NativeAdLayout To Render Ad
        mMixFullScreenAd.setNativeAdLayout(NativeAdLayout.getFullLayout1());
        // Set MixFullScreenAd Load Event
        mMixFullScreenAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "MixFullScreenAd onAdLoaded");
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "MixFullScreenAd onAdFailedToLoad: " + adError.toString());
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "MixFullScreenAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "MixFullScreenAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "MixFullScreenAd onAdClosed");
            }
        });
    }
}
