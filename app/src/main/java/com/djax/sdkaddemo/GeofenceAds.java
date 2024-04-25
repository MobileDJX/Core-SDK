package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.GeofenceADS;

public class GeofenceAds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geofence_ads);


        ((TextView) findViewById(R.id.header)).setText("Geofence Ads");

        GeofenceADS.show(this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(GeofenceAds.this, HomeActivity.class));
        finish();
    }
}