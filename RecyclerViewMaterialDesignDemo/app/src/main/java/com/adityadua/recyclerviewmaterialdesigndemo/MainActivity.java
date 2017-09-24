package com.adityadua.recyclerviewmaterialdesigndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rc = (RecyclerView)findViewById(R.id.recycler);


        ItemData itemData[] = {
             new ItemData("Android 4.0 : JB",R.drawable.andoridjb),
             new ItemData("Android 6.0 : Marshamllow",R.drawable.marshmallow),
             new ItemData("Android 8.0 : Oreo",R.drawable.androidoreo)
        };

        rc.setLayoutManager(new LinearLayoutManager(this));

        MyAdaptor myAdaptor = new MyAdaptor(itemData);
        rc.setAdapter(myAdaptor);





        rc.setItemAnimator(new DefaultItemAnimator());

    }
}
