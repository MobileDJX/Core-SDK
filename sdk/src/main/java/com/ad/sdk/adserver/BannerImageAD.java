package com.ad.sdk.adserver;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ad.sdk.adserver.Listener.BannerListener;
import com.ad.sdk.utils.LoadData;

import java.util.Timer;
import java.util.TimerTask;

public class BannerImageAD {

    static Context context;

    static Timer timer;

    @SuppressLint("SetJavaScriptEnabled")
    public static void show(Context adViewContext, BannerPosition position, BannerListener listener) {

        try {
            context = adViewContext;
            Activity mActivity = (Activity) adViewContext;

            //Add this wherever your code needs to add the ad
            LinearLayout layout = new LinearLayout(mActivity);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.setLayoutParams(params);

            //Additionally to adjust the position to Bottom
            layout.setGravity(Gravity.BOTTOM);

            // Create a banner ad
            WebView webView = new WebView(mActivity);

            //Cookies


            CookieManager cookieManager = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cookieManager.setAcceptThirdPartyCookies(webView, true);


            } else {
                cookieManager.setAcceptCookie(true);
                cookieManager.acceptCookie();
                CookieManager.setAcceptFileSchemeCookies(true);
            }


//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                CookieManager cookieManager = CookieManager.getInstance();
//                cookieManager.setAcceptThirdPartyCookies(webView, true);
//                CookieManager.setAcceptFileSchemeCookies(true);
//                cookieManager.setAcceptCookie(true);
//                cookieManager.acceptCookie();
//            }


            SharedPreferences sharedPreferences = context.getSharedPreferences("BannerAds", Context.MODE_PRIVATE);

            String PortraitHtmlCode = new LoadData().loadBannerImage(mActivity);
//            String PortraitHtmlCode = "<script type='text/javascript' src='https://revphpe.djaxbidder.com/sdkadvanced/www/admin/plugins/mobileAdsDelivery/floatal.php?zoneid=262&width=&height=&keywords=&lattitude=&longitude=&systemtype=&ip=&layerstyle=&screenwidth=&screenheight=&displaywidth=&displayheight=&displaytype=&devicemodel=&devicebrand=&deviceos=&deviceosversion=&is_js_enabled=&carrier=&country=&countryname=&region=&city=&useragent=&language=&postalcode=&device_appid=&device_app_cat=&device_app_sha1=&device_app_md5=&device_app_dpidsha1=&device_app_dpidmd5=&device_app_ipv6=&udid=&timezone=&dataspeed=&connection=keep-alive&connectiontype=&Viewername=&Vieweremail=&Viewerphone=&Viewergender=&Viewerage=&userid=&publisherid=99&layerstyle=simple&request_id=&viewerid=&hide=0&trail=0&stickyness=2'></script>";
            String LandScapeHtmlCode = new LoadData().loadLandscapeBannerImage(mActivity);
            int AdRefresh = sharedPreferences.getInt("AdRefreshTime", 0);

            if (PortraitHtmlCode.isEmpty()) {
                listener.onAdsAdFailed();
            }


            webView.setBackgroundColor(0);
            webView.setPadding(0, 0, 0, 0);
            webView.getSettings().setJavaScriptEnabled(true);
            String html = "<!DOCTYPE html><html>" + "<style type='text/css'>" + "html,body {margin: 0;padding: 0;width: 100%;height: 100%;}" + "html {display: table;}" + "body {display: table-cell;vertical-align: middle;text-align: center;}" + "img{display: inline;height: auto;max-width: 100%;}" + "</style>" + "<body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";>" + PortraitHtmlCode + "</body></html>";
            webView.loadData(html, "text/html", "UTF-8");
            webView.setClickable(true);
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);


//            int orientation = mActivity.getResources().getConfiguration().orientation;
//            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//                Log.e("Orientation", "" + "Portrait");
//
//                webView.setBackgroundColor(0);
//                webView.setPadding(0, 0, 0, 0);
//                webView.getSettings().setJavaScriptEnabled(true);
//                String html = "<!DOCTYPE html><html>" + "<style type='text/css'>" + "html,body {margin: 0;padding: 0;width: 100%;height: 100%;}" + "html {display: table;}" + "body {display: table-cell;vertical-align: middle;text-align: center;}" + "img{display: inline;height: auto;max-width: 100%;}" + "</style>" + "<body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";>" + PortraitHtmlCode + "</body></html>";
//
//                webView.loadData(html, "text/html", "UTF-8");
//                webView.setClickable(true);
//                webView.setVerticalScrollBarEnabled(false);
//                webView.setHorizontalScrollBarEnabled(false);
//
//            } else {
//
//                Log.e("Orientation", "" + "Landscape");
//
//                webView.setBackgroundColor(Color.GRAY);
//                webView.setPadding(0, 0, 0, 0);
//                webView.getSettings().setJavaScriptEnabled(true);
//                String html = "<!DOCTYPE html><html>" + "<style type='text/css'>" + "html,body {margin: 0;padding: 0;width: 100%;height: 100%;}" + "html {display: table;}" + "body {display: table-cell;vertical-align: middle;text-align: center;}" + "img{display: inline;height: auto;max-width: 100%;}" + "</style>" + "<body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";>" + LandScapeHtmlCode + "</body></html>";
//
//                webView.loadData(html, "text/html", "UTF-8");
//                webView.setClickable(true);
//                webView.setVerticalScrollBarEnabled(false);
//                webView.setHorizontalScrollBarEnabled(false);

//            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//            int width = display.getWidth();
//            int height = display.getHeight();
//
//            int pixeldpi = Resources.getSystem().getDisplayMetrics().densityDpi;
//
//
//            int width_dp = (width / pixeldpi) * 160;
//            int height_dp = (height / pixeldpi) * 160;
//
//            Log.d("Landscape", "width: " + width);
//            Log.d("Landscape", "widthInDP: " + width_dp);
//            Log.d("Landscape", "height: " + height);
//            Log.d("Landscape", "heightInDP: " + height_dp);
//            Log.d("Landscape", "density: " + pixeldpi);
//
//
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            webView.setLayoutParams(params2);

//            }

            layout.addView(webView);


            if (AdRefresh > 0) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if ((!mActivity.isDestroyed())) {
                                    webView.reload();
                                }
                            }
                        });

                    }
                }, 0, AdRefresh * 1000L);

            } else {
                Log.e("AdRefresh", "Time " + " Null");
            }




            if (position == BannerPosition.TOP) {
                ViewGroup.LayoutParams bannerLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                mActivity.addContentView(layout, bannerLayout);
            } else {
                ViewGroup.LayoutParams bannerLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                mActivity.addContentView(layout, bannerLayout);
            }


            if (!PortraitHtmlCode.isEmpty()) {
                listener.onAdsAdLoaded();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}


