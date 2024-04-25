package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.InArticleVideoAds;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class InArticleVideo extends AppCompatActivity implements Player.Listener {

    public StyledPlayerView playerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_article_video);

        ((TextView) findViewById(R.id.header)).setText("InArticle Ad");

        playerView = findViewById(R.id.player_view);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new InArticleVideoAds().loadAd(playerView, InArticleVideo.this);
            }
        }, 1200);


    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(InArticleVideo.this, HomeActivity.class));
        finish();
    }

}