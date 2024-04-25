package com.ad.sdk.adserver.Listener;

public interface PopupAdListener {

    void onAdsShowFailure();

    void onAdsShowStart();

    void onAdsShowClick();

    void onAdsShowComplete();

    void onAdsDismissed();
}
