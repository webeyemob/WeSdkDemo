package com.wesdk.demo.mix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.we.sdk.core.api.ad.mixfull.MixFullScreenAd;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

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
        mMixFullScreenAd.setAdUnitId("f2096b04-031e-46bc-8f92-e1c40a3881fe");
        // Set NativeAdLayout To Render Ad
        mMixFullScreenAd.setNativeAdLayout(NativeAdLayout.getFullLayout1());
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
