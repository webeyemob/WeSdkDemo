package com.wesdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.we.sdk.core.api.WeSdk;
import com.we.sdk.core.api.WeSdkConfiguration;
import com.we.sdk.core.api.ad.BannerAdView;
import com.we.sdk.core.api.ad.InterstitialAd;
import com.we.sdk.core.api.ad.MixViewAd;
import com.we.sdk.core.api.ad.RewardedVideoAd;
import com.we.sdk.core.api.ad.mixfull.MixFullScreenAd;
import com.we.sdk.core.api.ad.nativead.NativeAd;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.we.sdk.core.api.listener.SimpleRewardedVideoAdListener;
import com.we.sdk.core.api.utils.LogUtil;
import com.we.sdk.exchange.DspMob;

public class MainActivity extends Activity {

    private final String TAG = "MainActivity";

    // BannerAd
    private Button mBannerLoadButton;
    private BannerAdView mBannerAdView;

    // NativeAd
    private Button mNativeLoadButton;
    private NativeAd mNativeAd;

    // InterstitialAd
    private Button mInterstitialLoadButton;
    private Button mInterstitialShowButton;
    private InterstitialAd mInterstitialAd;

    // RewardedVideoAd
    private Button mRewardedLoadButton;
    private Button mRewardedShowButton;
    private RewardedVideoAd mRewardedVideoAd;

    // MixViewAd
    private Button mMixViewAdLoadButton;
    private MixViewAd mMixViewAd;

    // MixFullScreenAd
    private Button mMixFullAdLoadButton;
    private Button mMixFullAdShowButton;
    private MixFullScreenAd mMixFullScreenAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set GDPR
        WeSdk.getDefault().setGdprConsent(true);
        // Init With AppId
        WeSdkConfiguration configuration = new WeSdkConfiguration.Builder(this)
		.appId("14fac732-0853-4f1e-83a4-77db7915fc62")
                .build();
        WeSdk.getDefault().initialize(this, configuration);


        // Init Ads
        initBannerAdView();
        initNativeAd();
        initInterstitialAd();
        initRewardedVideoAd();
    }

    private void initBannerAdView() {
        // Create BannerAdView
        // You need set Activity as Context when:
        // - BannerAdView Contains Unity Ads
        mBannerAdView = new BannerAdView(this);
        mBannerAdView.setAdUnitId("e302ae32-d770-4635-9b2f-97fd024e059e");

        // Listen Ad load result
        mBannerAdView.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "BannerAdView onAdLoaded");
//                String html = mBannerAdView.getHtml();
//                BannerWebViewActivity.start(MainActivity.this, html);
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

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "BannerAdView onAdFailedToLoad: " + adError.toString());
            }
        });

        // Load Ad
        mBannerLoadButton = findViewById(R.id.banner_load);
        mBannerLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBannerAdView.loadAd();
            }
        });

        // Add BannerAdView to UI
        ViewGroup container = findViewById(R.id.banneradview_container);
        container.addView(mBannerAdView);
    }

    private void initNativeAd() {
        // Create NativeAd
        mNativeAd = new NativeAd(this);
        mNativeAd.setAdUnitId("444dd66b-af52-4fd1-9260-5559e7488432");

        // Set Single NativeAdLayout
        mNativeAd.setNativeAdLayout(NativeAdLayout.getLargeLayout());
        // Or Set NativeLayout Policy
        // nativeAd.setNativeAdLayout(new SequenceNativeAdLayoutPolicy.Builder()
        //         .add(NativeAdLayout.getSmallLayout())
        //         .add(NativeAdLayout.getMediumLayout())
        //         .add(NativeAdLayout.getLargeLayout())
        //         .build());

        // Listen Ad load result
        mNativeAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "NativeAd onAdLoaded");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "NativeAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "NativeAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "NativeAd onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "NativeAd onAdFailedToLoad: " + adError);
            }
        });

        // Load ad
        mNativeLoadButton = findViewById(R.id.nativead_load);
        mNativeLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNativeAd.loadAd();
            }
        });

        // Ad NativeAd to UI
        ViewGroup nativeAdContainer = findViewById(R.id.nativead_container);
        nativeAdContainer.addView(mNativeAd.getAdView());
    }

    private void initInterstitialAd() {
        // Create InterstitialAd
        // You need set Activity as Context when:
        // - InterstitialAd Contains AdColony
        // - InterstitialAd Contains Unity Ads
        mInterstitialAd = new InterstitialAd(this);
	mInterstitialAd.setAdUnitId("ecc5a7d7-872b-4c6c-a042-6b0b311ccc04");

        // Listen Ad load result
        mInterstitialAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "InterstitialAd onAdLoaded");
                mInterstitialShowButton.setEnabled(true);
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

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "InterstitialAd onAdFailedToLoad: " + adError);
            }
        });

        // Load ad
        mInterstitialLoadButton = findViewById(R.id.interstitial_load);
        mInterstitialLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterstitialAd.loadAd();
            }
        });

        // Show ad
        mInterstitialShowButton = findViewById(R.id.interstitial_show);
        mInterstitialShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isReady()) {
                    mInterstitialAd.show();
                }
                mInterstitialShowButton.setEnabled(false);
            }
        });
    }

    private void initRewardedVideoAd() {
        // Create RewardedVideoAd
        // You need set Activity as Context when:
        // - RewardedVideoAd Contains AdColony
        // - RewardedVideoAd Contains Unity Ads
        // - RewardedVideoAd Contains MoPub
        mRewardedVideoAd = new RewardedVideoAd(this);
        mRewardedVideoAd.setAdUnitId("cca19625-d829-4902-8164-1e75a0e5e6f5");

        // Listen Ad load result
        mRewardedVideoAd.setAdListener(new SimpleRewardedVideoAdListener() {
            @Override
            public void onAdLoaded() {
                LogUtil.d(TAG, "RewardedVideoAd onAdLoaded");
                mRewardedShowButton.setEnabled(true);
            }

            @Override
            public void onAdShown() {
                LogUtil.d(TAG, "RewardedVideoAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                LogUtil.d(TAG, "RewardedVideoAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                LogUtil.d(TAG, "RewardedVideoAd onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                LogUtil.d(TAG, "RewardedVideoAd onAdFailedToLoad: " + adError);
            }

            @Override
            public void onVideoStarted() {
                LogUtil.d(TAG, "RewardedVideoAd onVideoStarted");
            }

            @Override
            public void onVideoCompleted() {
                LogUtil.d(TAG, "RewardedVideoAd onVideoCompleted");
            }

            @Override
            public void onRewarded(RewardedVideoAd.RewardItem rewardItem) {
                LogUtil.d(TAG, "RewardedVideoAd onRewarded: " + rewardItem);
            }

            @Override
            public void onRewardFailed() {
                LogUtil.d(TAG, "RewardedVideoAd onRewardFailed");
            }
        });

        // Load ad
        mRewardedLoadButton = findViewById(R.id.rewarded_load);
        mRewardedLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRewardedVideoAd.loadAd();
            }
        });

        // Show ad
        mRewardedShowButton = findViewById(R.id.rewarded_show);
        mRewardedShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isReady()) {
                    mRewardedVideoAd.show();
                }
                mRewardedShowButton.setEnabled(false);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release when app exit.
        WeSdk.getDefault().release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // You should add onBackPressed callback if you mediation Chartboost.
        WeSdk.getDefault().onBackPressed(this);
    }
}
