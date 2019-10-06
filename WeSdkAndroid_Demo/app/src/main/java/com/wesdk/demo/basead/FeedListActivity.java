package com.wesdk.demo.basead;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.we.sdk.core.api.ad.feedlist.Feed;
import com.we.sdk.core.api.ad.feedlist.FeedList;
import com.we.sdk.core.api.ad.nativead.layout.NativeAdLayout;
import com.we.sdk.core.api.listener.AdError;
import com.we.sdk.core.api.listener.SimpleFeedAdListener;
import com.wesdk.demo.R;
import com.wesdk.demo.utils.ToastUtil;

import java.util.List;

public class FeedListActivity extends BaseActivity {

    private final String TAG = "FeedListActivity";

    private Button mLoadButton;
    private Button mShowButton;
    private LinearLayout mContainer;

    private FeedList mFeedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("FeedList");

        setContentView(R.layout.activity_feedlist);

        mLoadButton = findViewById(R.id.feedList_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load FeedList
                mFeedList.loadAd();
            }
        });

        mShowButton = findViewById(R.id.feedList_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Add FeedList AdView To UI
                List<Feed> feedList = mFeedList.getFeedList();
                if (feedList != null && !feedList.isEmpty()) {
                    mContainer.removeAllViews();
                    for (Feed feed : feedList) {
                        View adView = feed.getView();
                        if (adView != null) {
                            mContainer.addView(adView);
                        }
                    }
                }
            }
        });

        mContainer = findViewById(R.id.layout_container);

        // Init FeedList
        initFeedList();
    }

    private void initFeedList() {
        mFeedList = new FeedList(this);
        // Set AdUnitId
        mFeedList.setAdUnitId("06840669-d600-4a68-afeb-0015e6c7695a");
        // Set Ad Count You Want To Load
        mFeedList.setCount(3);
        // Set NativeAdLayout To Render Ad
        mFeedList.setDefaultAdLayout(NativeAdLayout.getLargeLayout1());
        // Set FeedList Load Event
        mFeedList.setAdListener(new SimpleFeedAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "FeedList onAdLoaded");
                mShowButton.setEnabled(true);
                ToastUtil.show(FeedListActivity.this, "FeedList Load Success");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "FeedList onAdFailedToLoad: " + adError.toString());
                ToastUtil.show(FeedListActivity.this, "FeedList Load Failed");
            }

            @Override
            public void onAdShown(@Nullable Feed feed) {
                Log.d(TAG, "FeedList onAdShown");
            }

            @Override
            public void onAdClicked(@Nullable Feed feed) {
                Log.d(TAG, "FeedList onAdClicked");
            }

            @Override
            public void onAdClosed(@Nullable Feed feed) {
                Log.d(TAG, "FeedList onAdClosed");
            }
        });
    }
}
