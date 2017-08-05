package com.adityadua.intents7demo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn,webbrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.nextActivity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

        webbrowser = (Button)findViewById(R.id.button2);
        webbrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                EditText edt = (EditText)findViewById(R.id.webAddress);
                //String url = edt.getText().toString();
                // httpwww.google.com

                //if(!url.startsWith("http://") && !url.startsWith("https://")){
               //     url="http://"+url;
               // }
                //i.setData(Uri.parse(url));
                //i.setData(Uri.parse("content://contacts/people/"));
                PackageManager pm = getPackageManager();
                List activity = pm.queryIntentActivities(i,PackageManager.MATCH_DEFAULT_ONLY);
                if(activity.size()>0) {
                    i.setData(Uri.parse("tel:123"));
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "No Options Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
