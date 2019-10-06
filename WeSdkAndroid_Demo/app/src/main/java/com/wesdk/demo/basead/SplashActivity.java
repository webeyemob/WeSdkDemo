package com.wesdk.demo.basead;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;

import com.we.sdk.core.api.ad.SplashAd;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

public class SplashActivity extends Activity {

    private final String TAG = "SplashActivity";

    private FrameLayout mContainer;
    private Handler mExitHandler;

    private SplashAd mSplashAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mContainer = findViewById(R.id.layout_container);

        // Exit Page When SplashAd Load More Than 3000ms
        mExitHandler = new Handler();
        mExitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);

        initSplash();

        // Load SplashAd
        mSplashAd.loadAd();
    }

    private void initSplash() {
        mSplashAd = new SplashAd(this);
        // Set AdUnitId
        mSplashAd.setAdUnitId("368537c2-0f9d-487d-955e-8f990fed9033");
        mSplashAd.setContainer(mContainer);
        // Set SplashAd Load Event
        mSplashAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "SplashAd onAdLoaded");
                mExitHandler.removeCallbacksAndMessages(null);
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "SplashAd onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(SplashActivity.this, "SplashAd Load Failed");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "SplashAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "SplashAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "SplashAd onAdClosed");
                // Exit Page When SplashAd Closed
                finish();
            }
        });
    }
}
