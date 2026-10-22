package com.bumbumapps;

import android.content.Context;

/** Kept for existing callers; interstitials go through {@link InterstitialHelper} (consent gated, 60 s cap). */
public final class AdsLoader {

    private AdsLoader() {
    }

    public static void setUpInterstitialAd(Context context) {
        InterstitialHelper.preload(context);
    }
}
