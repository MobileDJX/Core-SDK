package com.ad.sdk.adserver;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.ad.sdk.adserver.Listener.InterstitialAdShowListener;
import com.ad.sdk.adserver.Listener.InterstitialLoadAdListener;

public class LoadInterstitial {

    public static InterstitialLoadAdListener interstitialVideoAdListener = null;

    public static InterstitialAdShowListener int_show_listener = null;

    public static void setInterstitialVideoAdListener(InterstitialLoadAdListener interstitialVideoAdListener) {
        LoadInterstitial.interstitialVideoAdListener = interstitialVideoAdListener;
    }

    public static void setInt_show_listener(InterstitialAdShowListener int_show_listener) {
        LoadInterstitial.int_show_listener = int_show_listener;
    }


    @SuppressLint("LongLogTag")
    public static void show(Context context, InterstitialAdShowListener int_show_listener) {
        setInt_show_listener(int_show_listener);
        Intent i = new Intent(context, InterstitialLoadActivity.class);
//        Log.e("InterstitialVideoStatus:", "" + "Ad is showing");
        context.startActivity(i);
    }

}
