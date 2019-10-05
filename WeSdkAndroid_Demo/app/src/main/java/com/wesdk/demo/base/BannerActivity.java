package com.wesdk.demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.we.sdk.core.api.ad.BannerAdView;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

public class BannerActivity extends Activity {

    private final String TAG = "BannerActivity";

    private Button mLoadButton;
    private FrameLayout mContainer;

    private BannerAdView mBannerAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        mLoadButton = findViewById(R.id.banner_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load BannerAdView
                mBannerAdView.loadAd();
            }
        });

        // Init BannerAdView
        initBannerAdView();

        // Add BannerAdView To UI
        mContainer = findViewById(R.id.layout_banner);
        mContainer.addView(mBannerAdView);
    }

    private void initBannerAdView() {
        // You need set Activity as Context when:
        // - BannerAdView Contains Unity Ads
        mBannerAdView = new BannerAdView(this);
        // Set AdUnitId
        mBannerAdView.setAdUnitId("8b3efadd-71f2-4bba-9815-a9855c942b76");
        // Set BannerAdView Load Event
        mBannerAdView.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "BannerAdView onAdLoaded");
                ToastUtil.show(BannerActivity.this, "Banner Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "BannerAdView onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(BannerActivity.this, "Banner Load Failed");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "BannerAdView onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "BannerAdView onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "BannerAdView onAdClosed");
            }
        });
    }
}
