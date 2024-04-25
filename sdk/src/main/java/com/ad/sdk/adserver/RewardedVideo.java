package com.ad.sdk.adserver;


import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ad.sdk.adserver.Listener.RewardedAdLoadListener;
import com.ad.sdk.adserver.Listener.RewardedAdShowListener;


public class RewardedVideo {
    public static RewardedAdLoadListener rewardedListener = null;
    public static RewardedAdShowListener rewardedshowListener = null;

    static String ad_url;

    public static void setRewardedListen(RewardedAdLoadListener rewardadListen) {
        rewardedListener = rewardadListen;
    }

    public static void setRewardedshowListener(RewardedAdShowListener rewardedshowListener) {
        RewardedVideo.rewardedshowListener = rewardedshowListener;
    }

    @SuppressLint("LongLogTag")
    public static void load(Context context, RewardedAdLoadListener listener) {
        setRewardedListen(listener);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("RewardedVideo", MODE_PRIVATE);
            ad_url = sharedPreferences.getString("RewardedVideo_URL", "");
            String ad_check = sharedPreferences.getString("ad_check", "0");

            if (ad_check.equalsIgnoreCase("1")) {
                if (ad_url.length() > 0) {
                    Log.e("RewardedVideoStatus:", "" + "Ready to show");
                    listener.onAdsAdLoaded();
                } else {
                    Log.d("SDK", "No Ads:");
                    listener.onAdsAdFailed();
                }
            } else {
                Log.e("Ad Shown Status :", "Targeting Not Match");
            }

        } catch (Exception e) {
            Log.d("SDK", "Rewardedvideo Ad Exception:" + e);
        }


    }

    @SuppressLint("LongLogTag")
    public static void show(Context context, RewardedAdShowListener rewardedAdShowListener) {
        setRewardedshowListener(rewardedAdShowListener);

        if (ad_url.length() > 0) {
            Intent i = new Intent(context, RewardedLoadActivity.class);
            context.startActivity(i);
        }

    }
}


