package com.adityadua.broadcastreceiverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // Broadcast Recievr ::
    // remove your sIm Card ???
    // SO lets have a system which will read :
    // the SIM NUmber whenever the device reboots:::???
    // Broadvast Event : REBOOT : is done the system will start an app
    // say : ATMS :::
    // now in ATMS : you will check the previous with the current SIM Number ???
    // If it differs ,, you will have emergency contacts numbers availabel
    // Where you can send the sMS along with new SIM Number ?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        String id = "Test";
        Bundle b = i.getExtras();
        if(b!=null) id = b.getString("notification_id");
        Toast.makeText(this, "Notification Caught with id ::"+id, Toast.LENGTH_SHORT).show();
    }

}
