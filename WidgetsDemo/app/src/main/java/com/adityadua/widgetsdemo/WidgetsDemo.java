package com.adityadua.widgetsdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by AdityaDua on 10/09/17.
 */

public class WidgetsDemo extends AppWidgetProvider {
// In this class you will write : methods to update the view
// methods to perform some action

    // two types of context : ApplicationContext : limited but has a larger scope :

    // ActivityContext : is majorly for the Activity: it has more information
    // info about activity also ::


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int i=0;i<appWidgetIds.length;i++){
            int currentWidgetId = appWidgetIds[i];

            String url ="http://www.acadgild.com";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));
            
            // We need to add it to Pending intent because we are not aware 
            // when this will be called
            // PendingIntent : p

            PendingIntent pendingIntent= PendingIntent.getActivity(context,0,intent,0);

            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_view);
            views.setOnClickPendingIntent(R.id.button,pendingIntent);
            // This manager will be called and will have a task to
            // link the AppWidget to the RemoteView
            appWidgetManager.updateAppWidget(currentWidgetId,views);
            Toast.makeText(context, "Widget Added", Toast.LENGTH_SHORT).show();
            
            
        }


    }

}
