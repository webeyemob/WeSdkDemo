package com.wesdk.demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.we.sdk.core.api.ad.InterstitialAd;
import com.we.sdk.core.api.ad.feedlist.Feed;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

import java.util.List;

public class InterstitialActivity extends Activity {

    private final String TAG = "InterstitialActivity";

    private Button mLoadButton;
    private Button mShowButton;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mLoadButton = findViewById(R.id.interstitial_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load InterstitialAd
                mInterstitialAd.loadAd();
            }
        });

        mShowButton = findViewById(R.id.interstitial_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Show InterstitialAd
                mInterstitialAd.show();
            }
        });

        // Init InterstitialAd
        initInterstitialAd();
    }

    private void initInterstitialAd() {
        // You need set Activity as Context when:
        // - InterstitialAd Contains AdColony
        // - InterstitialAd Contains Unity Ads
        mInterstitialAd = new InterstitialAd(this);
        // Set AdUnitId
        mInterstitialAd.setAdUnitId("6a721d64-be26-4f62-9b38-1a63456ac2bc");
        // Set InterstitialAd Load Event
        mInterstitialAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "InterstitialAd onAdLoaded");
                mShowButton.setEnabled(true);
                ToastUtil.show(InterstitialActivity.this, "InterstitialAd Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "InterstitialAd onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(InterstitialActivity.this, "InterstitialAd Load Failed");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "InterstitialAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "InterstitialAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "InterstitialAd onAdClosed");
            }
        });
    }
}
