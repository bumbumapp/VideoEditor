package com.arthenica.mobileffmpeg;

/** Compatibility adapter for the retired mobile-ffmpeg API (see {@link FFmpeg}). */
public interface ExecuteCallback {
    void apply(long executionId, int returnCode);
}
