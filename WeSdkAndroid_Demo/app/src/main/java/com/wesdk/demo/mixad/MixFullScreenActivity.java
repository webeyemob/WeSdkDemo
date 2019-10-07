package com.wesdk.demo.mixad;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.we.sdk.core.api.ad.mixfull.MixFullScreenAd;
import com.we.sdk.core.api.ad.nativead.layout.MultiStyleNativeAdLayout;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.ad.nativead.layout.SequenceNativeAdLayoutPolicy;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.basead.BaseActivity;
import com.wesdk.demo.utils.ToastUtil;

public class MixFullScreenActivity extends BaseActivity {

    private final String TAG = "MixFullScreenActivity";

    private Button mLoadButton;
    private Button mShowButton;

    private MixFullScreenAd mMixFullScreenAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("MixFullScreenAd");

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
        mMixFullScreenAd.setAdUnitId("f2096b04-031e-46bc-8f92-e1c40a3881fe");

        // Set Custom NativeAdLayout To Render Ad
        mMixFullScreenAd.setNativeAdLayout(NativeAdLayout.Builder()
                .setLayoutIdWithDefaultViewId(R.layout.mixfull_custom_layout)
                .build());

        // Or Set NativeAdLayout Supported By WeSdk To Render Ad
//        mMixFullScreenAd.setNativeAdLayout(NativeAdLayout.getFullLayout1());

        // Or Set NativeAdLayoutPolicy To Render Ad
        // WeSdk Support SequenceNativeAdLayoutPolicy And RandomNativeAdLayoutPolicy
        // You Can Implement Your NativeAdLayoutPolicy
//        mMixFullScreenAd.setNativeAdLayout(SequenceNativeAdLayoutPolicy.Builder()
//                .add(NativeAdLayout.getFullLayout1())
//                .add(NativeAdLayout.getFullLayout2())
//                .add(NativeAdLayout.getFullLayout3())
//                .add(NativeAdLayout.getFullLayout4())
//                .build());

        // Or Set MultiStyleNativeAdLayout To Render Ad
//        mMixFullScreenAd.setNativeAdLayout(MultiStyleNativeAdLayout.Builder()
//                .setDefaultLayout(NativeAdLayout.getFullLayout1())
//                .setLargeImageLayout(NativeAdLayout.getFullLayout2())
//                .setGroupImageLayout(NativeAdLayout.getFullLayout3())
//                .setVideoLayout(NativeAdLayout.getFullLayout4())
//                .build());

        // Set MixFullScreenAd Load Event
        mMixFullScreenAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "MixFullScreenAd onAdLoaded");
                mShowButton.setEnabled(true);
                ToastUtil.show(MixFullScreenActivity.this, "MixFullScreenAd Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "MixFullScreenAd onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(MixFullScreenActivity.this, "MixFullScreenAd Load Failed");
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
