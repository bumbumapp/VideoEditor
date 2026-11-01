package com.bumbumapps;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.NonPersonalizedAd;
import com.huawei.hms.ads.RequestOptions;

/**
 * Huawei AppGallery build: same API as the Play build, but Huawei Ads (Petal) instead of AdMob.
 * Only non-personalized ads are requested, so no consent form is needed.
 */
public final class AdsConsent {

    private static final String TAG = "AdsConsent";
    private static volatile boolean sdkReady;

    private AdsConsent() {
    }

    /** Initialises Huawei Ads (non-personalized) and runs {@code onReady} on the UI thread. */
    public static void gather(Activity activity, Runnable onReady) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (!sdkReady) {
            try {
                HwAds.init(activity.getApplicationContext());
                RequestOptions options = HwAds.getRequestOptions().toBuilder()
                        .setNonPersonalizedAd(NonPersonalizedAd.ALLOW_NON_PERSONALIZED)
                        .build();
                HwAds.setRequestOptions(options);
                sdkReady = true;
            } catch (RuntimeException e) {
                Log.w(TAG, "Huawei Ads init failed", e);
                return;
            }
        }
        activity.runOnUiThread(() -> {
            if (!activity.isFinishing() && !activity.isDestroyed() && onReady != null) {
                onReady.run();
            }
        });
    }

    public static boolean canRequestAds(Context context) {
        return sdkReady;
    }

    public static boolean isPrivacyOptionsRequired(Context context) {
        return false;
    }

    public static void showPrivacyOptions(Activity activity) {
    }

    /** Huawei test slots in debug builds, the real (or still test) slots in release. */
    static String slot(Context context, int real, int test) {
        return context.getString(com.bumbumapps.videoeditor.BuildConfig.DEBUG ? test : real);
    }
}
