package com.adityadua.broadcastreceiver19demo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by AdityaDua on 09/08/17.
 */

public class MyBroadcast extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadcast Receiver Executed", Toast.LENGTH_SHORT).show();
// start a service which will show the symbol of charging
/*
        Intent i;
        i = new Intent(context,MyService.class);*/


        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(
                context.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Time Changed Successfully")
                .setContentTitle("Time Change Success")
                .setAutoCancel(true);

        Intent result = new Intent(context,MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context.getApplicationContext());
        stackBuilder.addParentStack(MainActivity.class);

        stackBuilder.addNextIntent(result);


       // PendingIntent resultP = stackBuilder.getPendingIntent()
        PendingIntent resultPI = PendingIntent.getActivity(context,0,result,0);

        mBuilder.setContentIntent(resultPI);


        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100,mBuilder.build());



        mp = MediaPlayer.create(context,R.raw.ringtone);
        mp.start();



    }
}
