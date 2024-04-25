package com.ad.sdk.adserver.Listener;

public interface InterstitialAdShowListener {

    void onAdsShowFailure();

    void onAdsShowStart();

    void onAdsShowClick();

    void onAdsShowComplete();

    void onAdsDismissed();
}
