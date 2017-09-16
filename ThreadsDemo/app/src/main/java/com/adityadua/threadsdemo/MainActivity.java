package com.adityadua.threadsdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button load,check;
    private Bitmap mBitmap;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        load = (Button)findViewById(R.id.button);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIcon();
            }
        });
        check = (Button)findViewById(R.id.button2);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "I am still working", Toast.LENGTH_SHORT).show();
            }
        });

        Button intentButton = (Button)findViewById(R.id.button3);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AsyncTaskActivity.class);
                startActivity(i);
            }
        });

    }

    public void loadIcon(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // First we create the Bitmap from the Image &

                mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.acadgild_logo);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // then we set the bitmap into the Image View
                        imageView.setImageBitmap(mBitmap);

                    }
                });



            }
        }).start();
    }
}
