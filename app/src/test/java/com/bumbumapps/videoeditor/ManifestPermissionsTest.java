package com.bumbumapps.videoeditor;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.junit.Test;

/**
 * Regression for card #64: the editor declared contacts, camera and media-location permissions it never
 * uses. Play treats unused sensitive permissions as a User Data policy violation (app was removed).
 */
public class ManifestPermissionsTest {
    private static final String[] UNUSED = {
            "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS",
            "android.permission.CAMERA", "android.permission.ACCESS_MEDIA_LOCATION"};

    @Test
    public void doesNotDeclareUnusedSensitivePermissions() throws Exception {
        String manifest = new String(Files.readAllBytes(new File("src/main/AndroidManifest.xml").toPath()),
                StandardCharsets.UTF_8);
        for (String permission : UNUSED) {
            assertFalse(permission + " must not be declared", manifest.contains(permission));
        }
    }
}
