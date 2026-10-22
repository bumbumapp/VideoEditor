package com.bumbumapps.videoeditor;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StartActivityPermissionsTest {

    @Test
    public void android13AsksForTheRealMediaPermissions() {
        assertArrayEquals(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO",
                "android.permission.READ_MEDIA_VIDEO"}, StartActivity.requiredMediaPermissions(33));
    }

    @Test
    public void olderVersionsUseStoragePermissions() {
        assertArrayEquals(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, StartActivity.requiredMediaPermissions(30));
        assertArrayEquals(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"},
                StartActivity.requiredMediaPermissions(28));
    }
}
