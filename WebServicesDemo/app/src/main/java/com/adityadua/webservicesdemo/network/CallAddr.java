package com.adityadua.webservicesdemo.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.adityadua.webservicesdemo.utilities.CommonUtilities;
import com.adityadua.webservicesdemo.utilities.OnWebserviceResult;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdityaDua on 29/10/17.
 */

public class CallAddr extends AsyncTask<String,Void,String> {

    Context context;
    String result = "";
    FormEncodingBuilder formBody;
    String url;
    OnWebserviceResult resultListener;
    CommonUtilities.SERVICE_TYPE service_type;
    Request request;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public CallAddr(Context context, FormEncodingBuilder formBody, OnWebserviceResult resultListener, CommonUtilities.SERVICE_TYPE service_type,String url) {
        this.context = context;
        this.formBody = formBody;
        this.resultListener = resultListener;
        this.service_type = service_type;
        this.url = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(120, TimeUnit.SECONDS);
        client.setReadTimeout(180,TimeUnit.SECONDS);


        RequestBody body = formBody.build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try{
            Response response = client.newCall(request).execute();

            if(response.isSuccessful()){
                result = response.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("Url is ::",url);
        Log.i("Response:",result);

        resultListener.getWebResponse(result,service_type);
    }
}
