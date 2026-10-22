package com.arthenica.mobileffmpeg;

import android.os.Handler;
import android.os.Looper;

import com.antonkarpenko.ffmpegkit.FFmpegKit;
import com.antonkarpenko.ffmpegkit.FFmpegSession;
import com.antonkarpenko.ffmpegkit.ReturnCode;

/**
 * Adapter that keeps the original com.arthenica.mobileffmpeg API used across the app while running
 * on a maintained, 16 KB page aligned FFmpegKit build (com.antonkarpenko:ffmpeg-kit). As in
 * mobile-ffmpeg, the callback is delivered on the main thread.
 */
public final class FFmpeg {

    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    private FFmpeg() {
    }

    public static long executeAsync(String command, ExecuteCallback callback) {
        FFmpegSession session = FFmpegKit.executeAsync(command, s -> deliver(s, callback));
        return session.getSessionId();
    }

    public static long executeAsync(String[] arguments, ExecuteCallback callback) {
        FFmpegSession session = FFmpegKit.executeWithArgumentsAsync(arguments, s -> deliver(s, callback));
        return session.getSessionId();
    }

    public static void cancel() {
        FFmpegKit.cancel();
    }

    public static void cancel(long executionId) {
        FFmpegKit.cancel(executionId);
    }

    private static void deliver(FFmpegSession session, ExecuteCallback callback) {
        Config.lastCommandOutput = session.getOutput();
        final int rc = toLegacyReturnCode(session.getReturnCode());
        final long id = session.getSessionId();
        if (callback != null) {
            MAIN.post(() -> callback.apply(id, rc));
        }
    }

    /** mobile-ffmpeg reported 0 for success, 255 for cancel and the ffmpeg exit code otherwise. */
    static int toLegacyReturnCode(ReturnCode code) {
        if (code == null) {
            return 1;
        }
        if (code.isValueSuccess()) {
            return Config.RETURN_CODE_SUCCESS;
        }
        if (code.isValueCancel()) {
            return Config.RETURN_CODE_CANCEL;
        }
        int value = code.getValue();
        return value == 0 ? 1 : value;
    }
}
