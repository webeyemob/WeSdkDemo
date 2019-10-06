package com.wesdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.we.sdk.core.api.WeSdk;
import com.wesdk.demo.basead.BannerActivity;
import com.wesdk.demo.basead.FeedListActivity;
import com.wesdk.demo.basead.InterstitialActivity;
import com.wesdk.demo.basead.NativeActivity;
import com.wesdk.demo.basead.RewardedVideoActivity;
import com.wesdk.demo.basead.SplashActivity;
import com.wesdk.demo.mixad.MixFullScreenActivity;
import com.wesdk.demo.mixad.MixViewActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBannerButton;
    private Button mInterstitialButton;
    private Button mRewardedVideoButton;
    private Button mNativeButton;

    private Button mSplashButton;
    private Button mFeedListButton;

    private Button mMixViewButton;
    private Button mMixFullScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBannerButton = findViewById(R.id.banner_button);
        mBannerButton.setOnClickListener(this);

        mInterstitialButton = findViewById(R.id.interstitial_button);
        mInterstitialButton.setOnClickListener(this);

        mRewardedVideoButton = findViewById(R.id.rewardedvideo_button);
        mRewardedVideoButton.setOnClickListener(this);

        mNativeButton = findViewById(R.id.native_button);
        mNativeButton.setOnClickListener(this);

        mSplashButton = findViewById(R.id.splash_button);
        mSplashButton.setOnClickListener(this);

        mFeedListButton = findViewById(R.id.feedlist_button);
        mFeedListButton.setOnClickListener(this);

        mMixViewButton = findViewById(R.id.mixview_button);
        mMixViewButton.setOnClickListener(this);

        mMixFullScreenButton = findViewById(R.id.mixfullscreen_button);
        mMixFullScreenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner_button:
                startAd(BannerActivity.class);
                break;
            case R.id.interstitial_button:
                startAd(InterstitialActivity.class);
                break;
            case R.id.rewardedvideo_button:
                startAd(RewardedVideoActivity.class);
                break;
            case R.id.native_button:
                startAd(NativeActivity.class);
                break;
            case R.id.splash_button:
                startAd(SplashActivity.class);
                break;
            case R.id.feedlist_button:
                startAd(FeedListActivity.class);
                break;
            case R.id.mixview_button:
                startAd(MixViewActivity.class);
                break;
            case R.id.mixfullscreen_button:
                startAd(MixFullScreenActivity.class);
                break;
        }
    }

    private void startAd(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // You should add onBackPressed callback if you mediation Chartboost.
        WeSdk.getDefault().onBackPressed(this);
    }
}
