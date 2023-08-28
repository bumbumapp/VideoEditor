package com.bumbumapps;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdsLoader {
    public static InterstitialAd mInterstitialAd;

     public static void setUpInterstitialAd(Context context) {
         InterstitialAd.load(context, "ca-app-pub-8444865753152507/8366800364", new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
             @Override
             public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                 mInterstitialAd = interstitialAd;
             }

             @Override
             public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                 mInterstitialAd =null;
             }
         });
         }
    }


