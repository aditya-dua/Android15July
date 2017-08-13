package com.adityadua.animacti7demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by AdityaDua on 06/08/17.
 */

public class ActivityDemo extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // the first method to be called
        // make objects // set Listener
        //customize the UI
        // adding , the toolbar & intiizating the drawers
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String role = i.getStringExtra("role");
        if(role.equalsIgnoreCase("admin")){
            setContentView(R.layout.example1);
        }else if(role.equalsIgnoreCase("mentor")){
            setContentView(R.layout.example2);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "In onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // after the activity becomes live or
        // it comes to foreground after taht
        Toast.makeText(this, "In onResume()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "In onPuase()", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.example2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "In onStop()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "In onRestart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "In onDestroy()", Toast.LENGTH_SHORT).show();

        super.onDestroy();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("username","aditya");
    }
}
