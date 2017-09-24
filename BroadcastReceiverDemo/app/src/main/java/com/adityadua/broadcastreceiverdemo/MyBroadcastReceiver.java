package com.adityadua.broadcastreceiverdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by AdityaDua on 24/09/17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // To merge the concepts :: Lets fire a Notification over here ::;
        Toast.makeText(context, "Time Changed", Toast.LENGTH_SHORT).show();

        simpleNotification(context,intent);

    }

    private void simpleNotification(Context context,Intent intent){

        // NotificationCompat : Builder : builde ris basically to create dynamic view
        // on the buidler you will add the properties for Notifictaion
        // Icon.Text,Title and So On
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new
                NotificationCompat.Builder(context)
                .setContentTitle("Time Changed")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Time has been reset please have a look at your existing ALRAMS!");

        builder.setAutoCancel(true);
        Intent resultIntent = new Intent(context,MainActivity.class);
        intent.putExtra("notification_id",100);
        //context.startActivity();

        //   PendingIntent :::
        // Pending Intent In simple words can be taken as an Intent which is create dbut not yet fired by the user
        // its is the user's wish whenever he would fire the intent ::
        // he will intent by clicking on the Notifictaion of the App in the notifictaion panel ::::


        Bundle b = new Bundle();
        b.putString("notification_id","100");
        PendingIntent resultPI = PendingIntent.getActivity(context,100,resultIntent,0,b);



        builder.setContentIntent(resultPI);

        // NotificationManager :: Baiscally Notifictaions are a service whihc continues to execute till the time
        // the phone remains 'ON'
        // Now when we want to release a notifctaion :: we will get the current
        // instance of the NotificationManager and fire the curren tONE
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());


    }
}
