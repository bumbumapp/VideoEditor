package com.bumbumapps;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AdsLoader {
    public static InterstitialAd interstitialAd;

     public static void setUpInterstitialAd(Context context) {
         if (interstitialAd == null) {
             interstitialAd = new InterstitialAd(context);
             interstitialAd.setAdUnitId("ca-app-pub-8444865753152507/8366800364");
             interstitialAd.loadAd(new AdRequest.Builder().build());
         }
    }

}
