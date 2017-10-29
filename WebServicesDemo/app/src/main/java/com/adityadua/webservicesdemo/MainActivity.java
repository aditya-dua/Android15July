package com.adityadua.webservicesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.adityadua.webservicesdemo.adaptor.DataAdaptor;
import com.adityadua.webservicesdemo.model.DataHandler;
import com.adityadua.webservicesdemo.network.CallAddr;
import com.adityadua.webservicesdemo.network.NetworkStatus;
import com.adityadua.webservicesdemo.utilities.CommonUtilities;
import com.adityadua.webservicesdemo.utilities.OnWebserviceResult;
import com.squareup.okhttp.FormEncodingBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnWebserviceResult{

    String url ="http://api.themoviedb.org/3/movie/tt0816692/credits?api_key=8496be0b2149805afa458ab8ec27560c";
    List<DataHandler> model = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);



    }

    private void hitRequest(){

        FormEncodingBuilder paramaetrs = new FormEncodingBuilder();
        paramaetrs.add("page","1");

        if(NetworkStatus.getInstance(this).connectedToInternet()){
            CallAddr call = new CallAddr(this,paramaetrs,this, CommonUtilities.SERVICE_TYPE.GET_DATA,url);
            call.execute();

        }else{
            Toast.makeText(this, "Not Connected , Please retry", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type) {
        Log.i("response :",result);

        try{

            JSONObject obj = new JSONObject(result);

            JSONArray arr = new JSONArray("cast");

            for(int i=0;i<arr.length();i++){
                JSONObject jObj = arr.getJSONObject(i);


                DataHandler data = new DataHandler();
                data.setName(jObj.getString("name"));
                data.setCharacter(jObj.getString("name"));
                data.setCast_id(jObj.getInt("cast_id"));
                data.setOrder(jObj.getInt("order"));

                model.add(data);
            }
            DataAdaptor adap = new DataAdaptor(this,model);
            recyclerView.setAdapter(adap);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
