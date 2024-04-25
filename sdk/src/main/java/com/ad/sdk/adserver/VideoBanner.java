package com.ad.sdk.adserver;

import android.app.Activity;
import android.content.Context;

import com.ad.sdk.adserver.Listener.BannerListener;
import com.ad.sdk.utils.LoadData;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class VideoBanner {


    public static void loadAd(Context context, StyledPlayerView playerView) {

        String adType = new LoadData().getVideoBannerAdType(context);

        Activity mActivity = (Activity) context;

        if (adType.equalsIgnoreCase("Banner")) {

            BannerImageAD.show(context, BannerPosition.BOTTOM, new BannerListener() {
                @Override
                public void onAdsAdLoaded() {

                }

                @Override
                public void onAdsAdFailed() {

                }
            });

        } else {


            new BannerVideoActivity().loadAd(playerView, context);


        }
    }
}
