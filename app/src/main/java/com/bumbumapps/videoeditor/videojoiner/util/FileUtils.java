package com.bumbumapps.videoeditor.videojoiner.util;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;

import com.bumbumapps.videoeditor.R;
import com.bumbumapps.videoeditor.videojoiner.model.ImageSelect;
import com.bumbumapps.videoeditor.videojoiner.model.SelectBucketImage;

import java.util.ArrayList;

public class FileUtils {
    public static Bitmap bitmap;
    public static ArrayList<String> createImageList = new ArrayList<>();
    public static int height;
    public static ArrayList<SelectBucketImage> imageUri = new ArrayList<>();
    public static int imgCount;
    public static ArrayList<String> myUri = new ArrayList<>();
    public static ArrayList<ImageSelect> selectImageList = new ArrayList<>();
    public static int width;

    public static String getPath(Context context) {

            StringBuilder sb = new StringBuilder(String.valueOf(MediaStore.Video.Media.EXTERNAL_CONTENT_URI));
            sb.append("/");
            sb.append(context.getResources().getString(R.string.app_name));
            return sb.toString();

    }

    public static String getLong(Cursor cursor) {
        return String.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
    }
}
