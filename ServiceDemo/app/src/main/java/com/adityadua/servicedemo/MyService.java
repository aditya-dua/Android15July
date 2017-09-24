package com.adityadua.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by AdityaDua on 23/09/17.
 */

public class MyService extends Service {


    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song_1);

    }

    /*@Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        mediaPlayer.setLooping(true);

    }*/

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){

        }
        mediaPlayer.pause();
        mediaPlayer.release();
    }
}
