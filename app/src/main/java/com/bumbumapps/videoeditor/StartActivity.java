package com.bumbumapps.videoeditor;


import static com.bumbumapps.AdsLoader.mInterstitialAd;
import static com.bumbumapps.videoeditor.Globals.TIMER_FINISHED;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumbumapps.AdsLoader;
import com.bumbumapps.videoeditor.listmusicandmymusic.ListMusicAndMyMusicActivity;
import com.bumbumapps.videoeditor.listvideoandmyvideo.ListVideoAndMyAlbumActivity;
import com.bumbumapps.videoeditor.listvideowithmymusic.ListVideoAndMyMusicActivity;
import com.bumbumapps.videoeditor.phototovideo.SelectImageAndMyVideoActivity;
import com.bumbumapps.videoeditor.videocollage.ListCollageAndMyAlbumActivity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;

import com.google.android.material.appbar.AppBarLayout;



public class StartActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    static final boolean a = true;
    private Toolbar toolbar;
    private ImageView mProfileImage;

    private AdView adView;



    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        if (VERSION.SDK_INT >= 23) {
            if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGE", "android.permission.READ_MEDIA_AUDIO","android.permission.READ_MEDIA_VIDEO"}, 101);

            }else {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
            }
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
        loadbannerads();


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void videoCutter(View view) {showAds(ListVideoAndMyAlbumActivity.class,1);}
    public void videoCompress(View view) {showAds(ListVideoAndMyAlbumActivity.class,2);}
    public void videoToMp3(View view) {showAds(ListVideoAndMyMusicActivity.class,3);}
    public void audioVideoMixer(View view) {showAds(ListVideoAndMyAlbumActivity.class,4);}
    public void videoMute(View view) {showAds(ListVideoAndMyAlbumActivity.class,5);}
    public void videoJoin(View view) {showAds(com.bumbumapps.videoeditor.videojoiner.ListVideoAndMyAlbumActivity.class,6);}
    public void videoToImg(View view) {showAds(com.bumbumapps.videoeditor.videotogif.ListVideoAndMyAlbumActivity.class,7);}
    public void videoformatchange(View view) {showAds(ListVideoAndMyAlbumActivity.class,8);}
    public void fastmotion(View view) {showAds(ListVideoAndMyAlbumActivity.class,9);}
    public void slowmotion(View view) {showAds(ListVideoAndMyAlbumActivity.class,10);}
    public void videocrop(View view) {showAds(ListVideoAndMyAlbumActivity.class,11);}
    public void videotogif(View view) {showAds(com.bumbumapps.videoeditor.videotogif.ListVideoAndMyAlbumActivity.class,12);}
    public void videorotate(View view) {showAds(ListVideoAndMyAlbumActivity.class,13);}
    public void videomirror(View view) {showAds(ListVideoAndMyAlbumActivity.class,14);}
    public void videosplit(View view) {showAds(ListVideoAndMyAlbumActivity.class,15);}
    public void videoreverse(View view) {showAds(ListVideoAndMyAlbumActivity.class,16);}
    public void videocollage(View view) {showAds( ListCollageAndMyAlbumActivity.class,17);}
    public void audiocompress(View view) {showAds(ListMusicAndMyMusicActivity.class,18);}
    public void audiojoiner(View view) {showAds(ListMusicAndMyMusicActivity.class,19);}
    public void audiocutter(View view) {showAds(ListMusicAndMyMusicActivity.class,20);}
    public void phototovideo(View view) {showAds(SelectImageAndMyVideoActivity.class,21);}
    public void videowatermark(View view) {showAds(ListVideoAndMyAlbumActivity.class,22);}


    private void showAds(final Class activitys, final int id){
        if (TIMER_FINISHED && mInterstitialAd!=null){
                mInterstitialAd.show(this);
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        TIMER_FINISHED=false;
                        Timers.timer().start();
                        AdsLoader.setUpInterstitialAd(getBaseContext());
                        startedActivity(activitys,id);
                    }

                });


        }
        else {startedActivity(activitys,id);}
    }

    @SuppressLint("WrongConstant")
    private void startedActivity(Class activitys, int id) {
        Helper.ModuleId = id;
        Intent intent = new Intent(StartActivity.this, activitys);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }


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


    private void loadbannerads() {
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
