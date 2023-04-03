package com.bumbumapps.videoeditor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumbumapps.videoeditor.listmusicandmymusic.ListMusicAndMyMusicActivity;
import com.bumbumapps.videoeditor.listvideoandmyvideo.ListVideoAndMyAlbumActivity;
import com.bumbumapps.videoeditor.listvideowithmymusic.ListVideoAndMyMusicActivity;
import com.bumbumapps.videoeditor.phototovideo.SelectImageAndMyVideoActivity;
import com.bumbumapps.videoeditor.videocollage.ListCollageAndMyAlbumActivity;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.LoadAdError;
import com.google.android.material.appbar.AppBarLayout;

//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;

public class StartActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    static final boolean a = true;
    private Toolbar toolbar;
    private ImageView mProfileImage;

//    private AdView adView;
//    InterstitialAd InterstitialAd=new InterstitialAd(this);
//    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        if (VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
        }

        setContentView( R.layout.startactivity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appbarLayout = (AppBarLayout) findViewById(R.id.mainappbar);
        mProfileImage = (ImageView) findViewById(R.id.mainbackdrop);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onBackPressed();
            }
        });
        appbarLayout.addOnOffsetChangedListener(this);
        mMaxScrollSize = appbarLayout.getTotalScrollRange();
//        loadbannerads();
//        InterstitialAd.setAdUnitId("ca-app-pub-8444865753152507/8366800364");
//        scheduleInterstitial(InterstitialAd);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }
    @SuppressLint("WrongConstant")
    public void videocutter(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 1;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 1;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
//        }

    }

    @SuppressLint("WrongConstant")
    public void videocompress(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 2;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 2;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }

    @SuppressLint("WrongConstant")
    public void videotomp3(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 3;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyMusicActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 3;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyMusicActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }

    @SuppressLint("WrongConstant")
    public void audiovideomixer(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 4;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 4;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }
    @SuppressLint("WrongConstant")
    public void videomute(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 5;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 5;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }
    @SuppressLint("WrongConstant")
    public void videojoin(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 6;
//                    Intent intent = new Intent(StartActivity.this, com.bumbumapps.videoeditor.videojoiner.ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 6;
            Intent intent = new Intent(StartActivity.this, com.bumbumapps.videoeditor.videojoiner.ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }
    @SuppressLint("WrongConstant")
    public void videotoimg(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//
//                    Helper.ModuleId = 7;
//                    Intent intent = new Intent(StartActivity.this, com.bumbumapps.videoeditor.videotogif.ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {

            Helper.ModuleId = 7;
            Intent intent = new Intent(StartActivity.this, com.bumbumapps.videoeditor.videotogif.ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
//        }

    }
    @SuppressLint("WrongConstant")
    public void videoformatchange(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//
//                    Helper.ModuleId = 8;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {

            Helper.ModuleId = 8;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
//        }

    }
    @SuppressLint("WrongConstant")
    public void fastmotion(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//
//                    Helper.ModuleId = 9;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {

            Helper.ModuleId = 9;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }
    @SuppressLint("WrongConstant")
    public void slowmotion(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//
//                    Helper.ModuleId = 10;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 10;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }
    @SuppressLint("WrongConstant")
    public void videocrop(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//
//                    Helper.ModuleId = 11;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 11;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
//        }


    }
    @SuppressLint("WrongConstant")
    public void videotogif(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 12;
//                    Intent intent = new Intent(StartActivity.this, com.bumbumapps.videoeditor.videotogif.ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 12;
            Intent intent = new Intent(StartActivity.this, com.bumbumapps.videoeditor.videotogif.ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }
    @SuppressLint("WrongConstant")
    public void videorotate(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 13;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 13;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }
    @SuppressLint("WrongConstant")
    public void videomirror(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 14;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 14;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }



//    }
    @SuppressLint("WrongConstant")
    public void videosplit(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 15;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 15;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }
    @SuppressLint("WrongConstant")
    public void videoreverse(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 16;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 16;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }
    @SuppressLint("WrongConstant")
    public void videocollage(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 17;
//                    Intent intent = new Intent(StartActivity.this, ListCollageAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 17;
            Intent intent = new Intent(StartActivity.this, ListCollageAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }
    @SuppressLint("WrongConstant")
    public void audiocompress(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 18;
//                    Intent intent = new Intent(StartActivity.this, ListMusicAndMyMusicActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 18;
            Intent intent = new Intent(StartActivity.this, ListMusicAndMyMusicActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }
    @SuppressLint("WrongConstant")
    public void audiojoiner(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 19;
//                    Intent intent = new Intent(StartActivity.this, ListMusicAndMyMusicActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 19;
            Intent intent = new Intent(StartActivity.this, ListMusicAndMyMusicActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }



//    }
    @SuppressLint("WrongConstant")
    public void audiocutter(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 20;
//                    Intent intent = new Intent(StartActivity.this, ListMusicAndMyMusicActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {
            Helper.ModuleId = 20;
            Intent intent = new Intent(StartActivity.this, ListMusicAndMyMusicActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }


//    }
    @SuppressLint("WrongConstant")
    public void phototovideo(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//
//                    Helper.ModuleId = 21;
//                    Intent intent = new Intent(StartActivity.this, SelectImageAndMyVideoActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {

            Helper.ModuleId = 21;
            Intent intent = new Intent(StartActivity.this, SelectImageAndMyVideoActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
//        }

    }
    @SuppressLint("WrongConstant")
    public void videowatermark(View view) {
//        if (InterstitialAd.isLoaded()){
//            InterstitialAd.show();
//            InterstitialAd.setAdListener(new AdListener(){
//                @Override
//                public void onAdClosed(){
//                    Helper.ModuleId = 22;
//                    Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
//                    intent.setFlags(67108864);
//                    startActivity(intent);
//                    finish();
//                }
//            });
//        }
//        else {

            Helper.ModuleId = 22;
            Intent intent = new Intent(StartActivity.this, ListVideoAndMyAlbumActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            finish();
        }

//    }




    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;
    private int mMaxScrollSize = 1;
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = 0;
        try {
            percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;

            toolbar.setTitle("");

        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;
            toolbar.setTitle("Video Editor");


        }
    }


//    private void loadbannerads() {
////        adView = findViewById(R.id.adView);
////        AdRequest adRequest = new AdRequest.Builder().build();
////        adView.loadAd(adRequest);
//    }
//    private void setUpInterstitialAd(InterstitialAd InterstitialAd) {
//        InterstitialAd.loadAd(new AdRequest.Builder().build());
//    }
//
//    private void scheduleInterstitial(final InterstitialAd InterstitialAd) {
//        scheduler.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        setUpInterstitialAd(InterstitialAd);
//                    }
//                });
//
//            }
//        }, 1, 300, TimeUnit.SECONDS);
//
//    }
}
