package com.bumbumapps.videoeditor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StartActivityGreetingTest {
    @Test
    public void greetingFollowsTimeOfDay() {
        assertEquals(R.string.greet_evening, StartActivity.greetingRes(4));
        assertEquals(R.string.greet_morning, StartActivity.greetingRes(5));
        assertEquals(R.string.greet_afternoon, StartActivity.greetingRes(12));
        assertEquals(R.string.greet_evening, StartActivity.greetingRes(18));
    }
}
