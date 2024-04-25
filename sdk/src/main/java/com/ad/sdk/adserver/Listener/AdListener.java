package com.ad.sdk.adserver.Listener;

import com.ad.sdk.adserver.AdsInitialize;

public interface AdListener {
	void param_required(AdsInitialize ad, boolean flag);
	
	void internet_connection_failed(AdsInitialize ad, boolean flag);
	
	void load_ad_failed(AdsInitialize ad, boolean flag, String ecode, String edesc);
	
}
