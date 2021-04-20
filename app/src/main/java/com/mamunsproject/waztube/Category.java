package com.mamunsproject.waztube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.facebook.ads.AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;

public class Category extends AppCompatActivity implements View.OnClickListener {

    private CardView lifeStyle, waz_videos, live_videos, prosno_porbo, facebook_posts;
    private AdView adView;
    private InterstitialAd interstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
// Initialize the Audience Network SDK
        AdSettings.setIntegrationErrorMode(INTEGRATION_ERROR_CRASH_DEBUG_MODE);
        AudienceNetworkAds.initialize(this);

        //===============================================FB INTERSTITIAL AD============================================

        interstitialAd = new InterstitialAd(getApplicationContext(), "446403776602085_446404353268694");


        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e("TAG", "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e("TAG", "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d("TAG", "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d("TAG", "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d("TAG", "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());



        ScheduledExecutorService scheduledExecutorService
                = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (interstitialAd.isAdInvalidated()) {
                            interstitialAd.loadAd();
                        }
//                        if (interstitialAd.isAdInvalidated()) {
//                            interstitialAd.loadAd();
//                        }

                    }
                });
            }
        },600,600, TimeUnit.SECONDS);


//===============================================FB INTERSTITIAL AD============================================
//===============================================FB BANNER AD============================================


        adView = new AdView(this, "446403776602085_446404209935375", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();


//===============================================FB BANNER AD============================================





        lifeStyle = findViewById(R.id.first);
        waz_videos = findViewById(R.id.second);
        live_videos = findViewById(R.id.third);
        prosno_porbo = findViewById(R.id.fourth);
        facebook_posts = findViewById(R.id.fifth);


        lifeStyle.setOnClickListener(this);
        waz_videos.setOnClickListener(this);
        live_videos.setOnClickListener(this);
        prosno_porbo.setOnClickListener(this);
        facebook_posts.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.first) {
            if (interstitialAd.isAdInvalidated()) {
                interstitialAd.loadAd();
            }
            startActivity(new Intent(getApplicationContext(), Life_Style_video.class));

        }

        if (v.getId() == R.id.second) {
            if (interstitialAd.isAdInvalidated()) {
                interstitialAd.loadAd();
            }
           startActivity(new Intent(getApplicationContext(), All_Waz.class));

        }

        if (v.getId() == R.id.third) {
            if (interstitialAd.isAdInvalidated()) {
                interstitialAd.loadAd();
            }
            startActivity(new Intent(getApplicationContext(), LiveVideos.class));

        }

        if (v.getId() == R.id.fourth) {
            if (interstitialAd.isAdInvalidated()) {
                interstitialAd.loadAd();
            }
            startActivity(new Intent(getApplicationContext(), Prosno_porbo.class));

        }


        if (v.getId() == R.id.fifth) {
            if (interstitialAd.isAdInvalidated()) {
                interstitialAd.loadAd();
            }
            startActivity(new Intent(getApplicationContext(), Links.class));


        }


    }
}