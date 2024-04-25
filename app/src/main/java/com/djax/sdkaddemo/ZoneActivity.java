package com.djax.sdkaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ad.sdk.adserver.AdsInitialize;
import com.ad.sdk.adserver.Listener.AdViewListener;


public class ZoneActivity extends AppCompatActivity {
    String zone_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);


        ((TextView) findViewById(R.id.header)).setText("Publisher ID");

        ((LinearLayout) findViewById(R.id.lay_zone)).setVisibility(View.VISIBLE);
        ((LinearLayout) findViewById(R.id.lay_response)).setVisibility(View.GONE);


        ((LinearLayout) findViewById(R.id.zone_btn_lay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((LinearLayout) findViewById(R.id.lay_zone)).setVisibility(View.VISIBLE);
                ((LinearLayout) findViewById(R.id.lay_response)).setVisibility(View.GONE);

            }
        });


        ((LinearLayout) findViewById(R.id.res_lay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((LinearLayout) findViewById(R.id.lay_zone)).setVisibility(View.GONE);
                ((LinearLayout) findViewById(R.id.lay_response)).setVisibility(View.VISIBLE);
            }
        });


        ((Button) findViewById(R.id.load_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                zone_id = ((EditText) findViewById(R.id.ed_zone_id)).getText().toString();

                AppApplication.editor.putString("Zone_ID", ((EditText) findViewById(R.id.ed_zone_id)).getText().toString());
                AppApplication.editor.commit();

                new AdsInitialize(ZoneActivity.this, zone_id, new AdViewListener() {
                    @Override
                    public void onInitializationComplete() {
                        startActivity(new Intent(ZoneActivity.this, HomeActivity.class));
                        finish();
                    }

                    @Override
                    public void onInitializationFailure() {

                    }
                });


            }
        });


    }


    @Override
    public void onBackPressed() {
        finish();
    }


}