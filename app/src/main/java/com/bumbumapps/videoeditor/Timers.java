package com.bumbumapps.videoeditor;

import android.os.CountDownTimer;
import android.util.Log;


public  class  Timers {

    public static CountDownTimer timer(){
        return new CountDownTimer(180000, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.d("millisUntilFinished",""+millisUntilFinished);
            }

            public void onFinish() {
                 Globals.TIMER_FINISHED = true;
            }
        };
    }

}