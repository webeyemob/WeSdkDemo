package com.wesdk.demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.we.sdk.core.api.ad.RewardedVideoAd;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleRewardedVideoAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

public class RewardedVideoActivity extends Activity {

    private final String TAG = "RewardedVideoActivity";

    private Button mLoadButton;
    private Button mShowButton;

    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewardedvideo);

        mLoadButton = findViewById(R.id.rewardedvideo_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load RewardedVideoAd
                mRewardedVideoAd.loadAd();
            }
        });

        mShowButton = findViewById(R.id.rewardedvideo_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Show RewardedVideoAd
                mRewardedVideoAd.show();
            }
        });

        // Init RewardedVideoAd
        initRewardedVideoAd();
    }

    private void initRewardedVideoAd() {
        // You need set Activity as Context when:
        // - RewardedVideoAd Contains AdColony
        // - RewardedVideoAd Contains Unity Ads
        // - RewardedVideoAd Contains MoPub
        mRewardedVideoAd = new RewardedVideoAd(this);
        // Set AdUnitId
        mRewardedVideoAd.setAdUnitId("d488acbc-899c-40c6-b088-fcbb0a563654");
        // Set RewardedVideoAd Load Event
        mRewardedVideoAd.setAdListener(new SimpleRewardedVideoAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "RewardedVideoAd onAdLoaded");
                mShowButton.setEnabled(true);
                ToastUtil.show(RewardedVideoActivity.this, "RewardedVideoAd Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "RewardedVideoAd onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(RewardedVideoActivity.this, "RewardedVideoAd Load Failed");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "RewardedVideoAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "RewardedVideoAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "RewardedVideoAd onAdClosed");
            }

            @Override
            public void onVideoStarted() {
                Log.d(TAG, "RewardedVideoAd onVideoStarted");
            }

            @Override
            public void onVideoCompleted() {
                Log.d(TAG, "RewardedVideoAd onVideoCompleted");
            }

            @Override
            public void onRewarded(RewardedVideoAd.RewardItem rewardItem) {
                Log.d(TAG, "RewardedVideoAd onRewarded");
                if (rewardItem != null) {
                    Log.d(TAG, "RewardedVideoAd RewardItem Is "
                            + rewardItem.getType() + ": " + rewardItem.getAmount());
                }
            }

            @Override
            public void onRewardFailed() {
                Log.d(TAG, "RewardedVideoAd onRewardFailed");
            }
        });
    }
}
