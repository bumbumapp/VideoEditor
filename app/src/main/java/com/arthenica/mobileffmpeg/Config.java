package com.arthenica.mobileffmpeg;

import android.util.Log;

/** Compatibility adapter for the retired mobile-ffmpeg API (see {@link FFmpeg}). */
public final class Config {

    public static final String TAG = "mobile-ffmpeg";
    public static final int RETURN_CODE_SUCCESS = 0;
    public static final int RETURN_CODE_CANCEL = 255;

    static volatile String lastCommandOutput = "";

    private Config() {
    }

    public static String getLastCommandOutput() {
        return lastCommandOutput;
    }

    public static void printLastCommandOutput(int logPriority) {
        String output = lastCommandOutput;
        if (output == null || output.isEmpty()) {
            return;
        }
        // Logcat truncates long lines; print in chunks.
        final int chunk = 4000;
        for (int i = 0; i < output.length(); i += chunk) {
            Log.println(logPriority, TAG, output.substring(i, Math.min(output.length(), i + chunk)));
        }
    }
}
