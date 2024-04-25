package com.ad.sdk.adserver.Listener;

public interface RewardedAdShowListener {

    void onAdsShowFailure();

    void onAdsShowStart();


    void onAdsShowClicked();

    void onAdsShowComplete();


    void Rewarded(String rewardItem, int rewarded);


}
