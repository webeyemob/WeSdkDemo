package com.wesdk.demo.mixad;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.we.sdk.core.api.ad.MixViewAd;
import com.we.sdk.core.api.ad.nativead.layout.MultiStyleNativeAdLayout;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.ad.nativead.layout.SequenceNativeAdLayoutPolicy;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.basead.BaseActivity;
import com.wesdk.demo.utils.ToastUtil;

public class MixViewActivity extends BaseActivity {

    private final String TAG = "MixViewActivity";

    private Button mLoadButton;
    private Button mShowButton;
    private FrameLayout mContainer;

    private MixViewAd mMixViewAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("MixViewAd");

        setContentView(R.layout.activity_mixview);

        mLoadButton = findViewById(R.id.mxiview_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load MixViewAd
                mMixViewAd.loadAd();
            }
        });

        mShowButton = findViewById(R.id.mxiview_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Add MixViewAd AdView To UI
                View adView = mMixViewAd.getAdView();
                if (adView != null) {
                    mContainer.removeAllViews();
                    mContainer.addView(adView);
                }
            }
        });

        mContainer = findViewById(R.id.layout_container);

        // Init MixViewAd
        initMixView();
    }

    private void initMixView() {
        mMixViewAd = new MixViewAd(this);
        // Set AdUnitId
        mMixViewAd.setAdUnitId("f7fcd8d4-ac3f-4bf0-9612-c9e33243ef74");

        // Set Custom NativeAdLayout To Render Ad
        mMixViewAd.setNativeAdLayout(NativeAdLayout.Builder()
                .setLayoutIdWithDefaultViewId(R.layout.native_custom_layout)
                .build());

        // Or Set NativeAdLayout Supported By WeSdk To Render Ad
//        mMixViewAd.setNativeAdLayout(NativeAdLayout.getLargeLayout1());

        // Or Set NativeAdLayoutPolicy To Render Ad
        // WeSdk Support SequenceNativeAdLayoutPolicy And RandomNativeAdLayoutPolicy
        // You Can Implement Your NativeAdLayoutPolicy
//        mMixViewAd.setNativeAdLayout(SequenceNativeAdLayoutPolicy.Builder()
//                .add(NativeAdLayout.getLargeLayout1())
//                .add(NativeAdLayout.getLargeLayout2())
//                .add(NativeAdLayout.getLargeLayout3())
//                .add(NativeAdLayout.getLargeLayout4())
//                .build());

        // Or Set MultiStyleNativeAdLayout To Render Ad
//        mMixViewAd.setNativeAdLayout(MultiStyleNativeAdLayout.Builder()
//                .setDefaultLayout(NativeAdLayout.getSmallLayout())
//                .setLargeImageLayout(NativeAdLayout.getLargeLayout3())
//                .setGroupImageLayout(NativeAdLayout.getLargeLayout2())
//                .setVideoLayout(NativeAdLayout.getLargeLayout4())
//                .build());

        // Set MixView Load Event
        mMixViewAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "MixViewAd onAdLoaded");
                mShowButton.setEnabled(true);
                ToastUtil.show(MixViewActivity.this, "MixViewAd Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "MixViewAd onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(MixViewActivity.this, "MixViewAd Load Failed");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "MixViewAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "MixViewAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "MixViewAd onAdClosed");
            }
        });
    }
}
