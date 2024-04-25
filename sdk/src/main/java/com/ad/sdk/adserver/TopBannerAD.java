package com.ad.sdk.adserver;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ad.sdk.adserver.Listener.BannerListener;
import com.ad.sdk.utils.LoadData;

public class TopBannerAD {

    @SuppressLint("SetJavaScriptEnabled")
    public static void show(Context adViewContext, BannerListener listener) {


        Activity mActivity = (Activity) adViewContext;

        //Add this wherever your code needs to add the ad
        LinearLayout layout = new LinearLayout(mActivity);

        //Additionally to adjust the position to Bottom
        layout.setGravity(Gravity.TOP);

//         Create a banner ad
        WebView webView = new WebView(mActivity);

        String HtmlCode = new LoadData().loadTopBanner(mActivity);


//        String HtmlCode = "<script>\n" +
//                "var OX_d8a3cb52 = '';\n" +
//                "OX_d8a3cb52 += \"<\"+\"div id=\\\"7b36c0bf81\\\">\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"div id=\\\"floor_wrapper7b36c0bf81\\\" class=\\\"floor_wrap\\\">\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"div id=\\\"exit_floor7b36c0bf81\\\">\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"img src=\\\"https://revphpe.djaxbidder.com/sdkadvanced/www/admin/plugins/mobileAdsDelivery/close.png\\\" onclick=\\\"adClose()\\\" id=\\\"pop17b36c0bf81\\\" style=\\\"cursor:pointer; width:20px; z-index: 999; right:0\\\" >\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/div>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"div id=\\\"floor_ad7b36c0bf81\\\">\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"div id=\\\"floor_img7b36c0bf81\\\"><\"+\"a href=\\\"https://revphpe.djaxbidder.com/sdkadvanced/www/delivery/cl.php?bannerid=233&zoneid=270&userid=&device_appid=&connectiontype=&devicebrand=&deviceos=&deviceosversion=&screenwidth=&screenheight=&carrier=&timezone=&udid=&useragent=&Viewername=&Vieweremail=&Viewerphone=&language=&dataspeed=&displaytype=&device_app_dpidmd5=&device_app_dpidsha1=&devicemodel=&sig=329ea88536c205ce2c0a009c99c614f3204cc9389dae0e7e81c219e1e397358b&dest=http%3A%2F%2Fwww.google.com\\\" target=\\\"_blank\\\" rel=\\\"noopener nofollow\\\">\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"img src=\\\"https://revphpe.djaxbidder.com/sdkadvanced/www/images/25857af7815eb223f0d014c82b3541d0.jpg\\\" width=\\\"320\\\" height=\\\"50\\\" alt=\\\"\\\" title=\\\"\\\" border=\\\"0\\\"/><\"+\"/a>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"div id=\\\"beacon7b36c0bf81\\\" style=\\\"position: absolute; left: 0px; top: 0px; visibility: hidden;\\\">\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"img src=\\\"https://revphpe.djaxbidder.com/sdkadvanced/www/delivery/lg.php?bannerid=233&campaignid=40&zoneid=270&loc=http%3A%2F%2Flocalhost%2F&cb=14d4e8fc5e&zoneid=270&width=&height=&keywords=&lattitude=&longitude=&systemtype=&ip=&layerstyle=simple&screenwidth=&screenheight=&displaywidth=&displayheight=&displaytype=&devicemodel=&devicebrand=&deviceos=&deviceosversion=&is_js_enabled=&carrier=&country=&countryname=&region=&city=&useragent=&language=&postalcode=&device_appid=&device_app_cat=&device_app_sha1=&device_app_md5=&device_app_dpidsha1=&device_app_dpidmd5=&device_app_ipv6=&udid=&timezone=&dataspeed=&connection=keep-alive&connectiontype=&Viewername=&Vieweremail=&Viewerphone=&Viewergender=&Viewerage=&userid=&publisherid=100&request_id=&viewerid=&hide=0&trail=0&stickyness=2\\\" width=\\\"0\\\" height=\\\"0\\\" alt=\\\"\\\" style=\\\"width: 0px; height: 0px;\\\" />\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/div>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/div>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/div>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/div>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/div>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"style>\\n\";\n" +
//                "OX_d8a3cb52 += \"#floor_wrapper7b36c0bf81\\n\";\n" +
//                "OX_d8a3cb52 += \"{\\n\";\n" +
//                "OX_d8a3cb52 += \"display: inline-block;\\n\";\n" +
//                "OX_d8a3cb52 += \"position: fixed;\\n\";\n" +
//                "OX_d8a3cb52 += \"z-index: 10000;\\n\";\n" +
//                "OX_d8a3cb52 += \"}\\n\";\n" +
//                "OX_d8a3cb52 += \"#pop17b36c0bf81\\n\";\n" +
//                "OX_d8a3cb52 += \"{\\n\";\n" +
//                "OX_d8a3cb52 += \"position:absolute;\\n\";\n" +
//                "OX_d8a3cb52 += \"}\\n\";\n" +
//                "OX_d8a3cb52 += \"#color7b36c0bf81\\n\";\n" +
//                "OX_d8a3cb52 += \"{\\n\";\n" +
//                "OX_d8a3cb52 += \"z-index: 10000;\\n\";\n" +
//                "OX_d8a3cb52 += \"background-color:rgba(192,192,192,50%);\\n\";\n" +
//                "OX_d8a3cb52 += \"position:fixed;\\n\";\n" +
//                "OX_d8a3cb52 += \"left:0;\\n\";\n" +
//                "OX_d8a3cb52 += \"}\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/style>\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"script>\\n\";\n" +
//                "OX_d8a3cb52 += \"window.onresize = function(){\\n\";\n" +
//                "OX_d8a3cb52 += \"location.reload();\\n\";\n" +
//                "OX_d8a3cb52 += \"}\\n\";\n" +
//                "OX_d8a3cb52 += \"var floorimg = document.getElementById(\\\"floor_img7b36c0bf81\\\");\\n\";\n" +
//                "OX_d8a3cb52 += \"var widht1 = 320;\\n\";\n" +
//                "OX_d8a3cb52 += \"var height1 =50;\\n\";\n" +
//                "OX_d8a3cb52 += \"divElement = document.querySelector(\\\"#floor_wrapper7b36c0bf81\\\");\\n\";\n" +
//                "OX_d8a3cb52 += \"elemHeight = divElement.offsetHeight;\\n\";\n" +
//                "OX_d8a3cb52 += \"var swidth = window.innerWidth;\\n\";\n" +
//                "OX_d8a3cb52 += \"var left_c= (swidth-widht1)/2;\\n\";\n" +
//                "OX_d8a3cb52 += \"var cont =  document.getElementById(\\\"floor_wrapper7b36c0bf81\\\");\\n\";\n" +
//                "OX_d8a3cb52 += \"cont.style.left=left_c + \\\"px\\\";\\n\";\n" +
//                "OX_d8a3cb52 += \"function adClose(){\\n\";\n" +
//                "OX_d8a3cb52 += \"document.getElementById(\\\"floor_wrapper7b36c0bf81\\\").style.display = \\\"none\\\";\\n\";\n" +
//                "OX_d8a3cb52 += \"}\\n\";\n" +
//                "OX_d8a3cb52 += \"<\"+\"/script>\\n\";\n" +
//                "document.write(OX_d8a3cb52);\n" +
//                "\n" +
//                "</script>";


//        String scriptTag = "<script> " + HtmlCode + " </script>";


        if (HtmlCode.isEmpty()) {
            listener.onAdsAdFailed();
        }

        int maxLogSize = 4000;
        for (int j = 0; j <= HtmlCode.length() / maxLogSize; j++) {
            int start = j * maxLogSize;
            int end = (j + 1) * maxLogSize;
            end = Math.min(end, HtmlCode.length());
        }

        webView.setBackgroundColor(0);
        webView.setPadding(0, 0, 0, 0);
        webView.getSettings().setJavaScriptEnabled(true);
        String html = "<!DOCTYPE html><html>" +
                "<style type='text/css'>" +
                "html,body {margin: 0;padding: 0;width: 100%;height: 100%;}" +
                "html {display: table;}" +
                "body {display: table-cell;vertical-align: middle;text-align: center;}" +
                "img{display: inline;height: auto;max-width: 100%;}" +
                "</style>" +
                "<body style= \"width=\"100%\";height=\"100%\";initial-scale=\"1.0\"; maximum-scale=\"1.0\"; user-scalable=\"no\";>" + HtmlCode + "</body></html>";

        webView.loadData(html, "text/html", "UTF-8");
        webView.setClickable(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);

        Log.e("Banner_Load", " Code : " + html);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }

        layout.addView(webView);

        ViewGroup.LayoutParams bannerLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        mActivity.addContentView(layout, bannerLayout);


    }

}
