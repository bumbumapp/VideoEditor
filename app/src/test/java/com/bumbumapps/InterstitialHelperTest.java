package com.bumbumapps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InterstitialHelperTest {
    private static final long MIN = 60_000L;

    @Test
    public void capConstants() {
        assertEquals(8 * MIN, InterstitialHelper.MIN_INTERVAL_MS);
        assertEquals(3 * MIN, InterstitialHelper.FIRST_GRACE_MS);
    }

    @Test
    public void noAdInTheFirstThreeMinutes() {
        long never = -InterstitialHelper.MIN_INTERVAL_MS;
        assertFalse(InterstitialHelper.capAllows(3 * MIN - 1, never, 0L));
        assertTrue(InterstitialHelper.capAllows(3 * MIN, never, 0L));
    }

    @Test
    public void eightMinutesBetweenAds() {
        long shown = 30 * MIN;
        assertFalse(InterstitialHelper.capAllows(shown + 8 * MIN - 1, shown, 0L));
        assertTrue(InterstitialHelper.capAllows(shown + 8 * MIN, shown, 0L));
    }
}
