package com.arthenica.mobileffmpeg;

import static org.junit.Assert.assertEquals;

import com.antonkarpenko.ffmpegkit.ReturnCode;

import org.junit.Test;

/** The adapter must keep mobile-ffmpeg's return codes that all screens compare against. */
public class FFmpegReturnCodeTest {

    @Test
    public void mapsFfmpegKitCodesToLegacyValues() {
        assertEquals(Config.RETURN_CODE_SUCCESS, FFmpeg.toLegacyReturnCode(new ReturnCode(0)));
        assertEquals(Config.RETURN_CODE_CANCEL, FFmpeg.toLegacyReturnCode(new ReturnCode(255)));
        assertEquals(1, FFmpeg.toLegacyReturnCode(new ReturnCode(1)));
        assertEquals(1, FFmpeg.toLegacyReturnCode(null));
    }
}
