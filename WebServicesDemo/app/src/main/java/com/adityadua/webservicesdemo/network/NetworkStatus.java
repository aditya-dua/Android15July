package com.adityadua.webservicesdemo.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by AdityaDua on 29/10/17.
 */

public class NetworkStatus {

    private static NetworkStatus instance = new NetworkStatus();

    static Context context;

    ConnectivityManager connectivityManager;

    boolean connected = false;

    public static NetworkStatus getInstance(Context c){
        context = c;
        return instance;
    }

    public boolean connectedToInternet(){
        connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo acticeNetwork = connectivityManager.getActiveNetworkInfo();
        if(acticeNetwork !=null){
            return  true;
        }


        return false;


    }
}
