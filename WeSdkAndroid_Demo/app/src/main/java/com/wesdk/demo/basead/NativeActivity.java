package com.wesdk.demo.basead;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.we.sdk.core.api.ad.nativead.NativeAd;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

public class NativeActivity extends Activity {

    private final String TAG = "NativeActivity";

    private Button mLoadButton;
    private Button mShowButton;
    private FrameLayout mContainer;

    private NativeAd mNativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);

        mLoadButton = findViewById(R.id.native_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load NativeAd
                mNativeAd.loadAd();
            }
        });

        mShowButton = findViewById(R.id.native_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Add NativeAd AdView To UI
                View adView = mNativeAd.getAdView();
                if (adView != null) {
                    mContainer.removeAllViews();
                    mContainer.addView(adView);
                }
            }
        });

        mContainer = findViewById(R.id.layout_container);

        // Init NativeAd
        initNative();
    }

    private void initNative() {
        mNativeAd = new NativeAd(this);
        // Set AdUnitId
        mNativeAd.setAdUnitId("817077e2-0448-44f9-8983-69e8e58534d1");

        // Set Custom NativeAdLayout To Render Ad
        mNativeAd.setNativeAdLayout(NativeAdLayout.Builder()
                .setLayoutIdWithDefaultViewId(R.layout.native_custom_layout)
                .build());

        // Or Set NativeAdLayout Supported By WeSdk To Render Ad
        // mNativeAd.setNativeAdLayout(NativeAdLayout.getLargeLayout1());

        // Or Set NativeAdLayout To Render Ad
        // mNativeAd.setNativeAdLayout(new SequenceNativeAdLayoutPolicy.Builder()
        // .add(NativeAdLayout.getLargeLayout1())
        // .add(NativeAdLayout.getLargeLayout2())
        // .add(NativeAdLayout.getLargeLayout3())
        // .add(NativeAdLayout.getLargeLayout4())
        // .build());

        // Set NativeAd Load Event
        mNativeAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "NativeAd onAdLoaded");
                mShowButton.setEnabled(true);
                ToastUtil.show(NativeActivity.this, "NativeAd Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "NativeAd onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(NativeActivity.this, "NativeAd Load Failed");
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
        });
    }
}
