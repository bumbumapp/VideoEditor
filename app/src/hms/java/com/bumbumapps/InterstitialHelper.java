package com.bumbumapps;

import com.bumbumapps.videoeditor.R;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.InterstitialAd;

/**
 * Huawei AppGallery build (Huawei Ads instead of AdMob), same API and cap as the Play build.
 * Single preloaded interstitial, shown when a tool is opened: at most one per 8 minutes and none
 * in the first 3 minutes after the app starts. Call {@link #preload(Context)} once ads can be
 * requested and {@link #showIfReady(Activity, Runnable)} at natural break points; {@code next} always runs
 * exactly once (after the ad is dismissed, or immediately if no ad is shown).
 */
public final class InterstitialHelper {

    public static final long MIN_INTERVAL_MS = 8 * 60_000L;
    public static final long FIRST_GRACE_MS = 3 * 60_000L;

    private static InterstitialAd interstitialAd;
    private static long lastShownAt = -MIN_INTERVAL_MS;
    private static long startedAt = -1L;

    private InterstitialHelper() {
    }

    public static void preload(Context context) {
        if (startedAt < 0) {
            startedAt = SystemClock.elapsedRealtime();
        }
        if (interstitialAd != null || !AdsConsent.canRequestAds(context)) {
            return;
        }
        Context app = context.getApplicationContext();
        InterstitialAd ad = new InterstitialAd(app);
        ad.setAdId(AdsConsent.slot(app, R.string.hms_interstitial_id, R.string.hms_test_interstitial_id));
        ad.setAdListener(new AdListener() {
            @Override
            public void onAdFailed(int code) {
                if (interstitialAd == ad) {
                    interstitialAd = null;
                }
            }
        });
        interstitialAd = ad;
        ad.loadAd(new AdParam.Builder().build());
    }

    /** Pure frequency-cap rule, unit tested. */
    static boolean capAllows(long now, long lastShown, long started) {
        return now - started >= FIRST_GRACE_MS && now - lastShown >= MIN_INTERVAL_MS;
    }

    public static void showIfReady(Activity activity, Runnable next) {
        final Runnable after = next != null ? next : () -> { };
        long now = SystemClock.elapsedRealtime();
        if (startedAt < 0) {
            startedAt = now;
        }
        InterstitialAd ad = interstitialAd;
        if (ad == null || !ad.isLoaded() || activity == null || activity.isFinishing() || !capAllows(now, lastShownAt, startedAt)) {
            if (activity != null) {
                preload(activity);
            }
            after.run();
            return;
        }
        interstitialAd = null;
        ad.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                preload(activity);
                after.run();
            }

            @Override
            public void onAdFailed(int code) {
                preload(activity);
                after.run();
            }
        });
        lastShownAt = now;
        ad.show(activity);
    }
}
