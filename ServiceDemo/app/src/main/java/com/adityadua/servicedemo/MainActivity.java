package com.adityadua.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn,stopBtn,playBtn;
    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.start);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,MyService.class);
                startService(i);
            }
        });

        stopBtn = (Button)findViewById(R.id.stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MyService.class);
                stopService(i);
            }
        });

        playBtn = (Button)findViewById(R.id.play);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playBtn.getText().toString().equalsIgnoreCase("Play")){
                    Intent i = new Intent(MainActivity.this,MyService.class);
                    startService(i);
                    //playBtn.se
                    playBtn.setText("Pause");
                }else if(playBtn.getText().toString().equalsIgnoreCase("Pause")){
                    Intent i = new Intent(MainActivity.this,MyService.class);
                    stopService(i);
                    playBtn.setText("Play");
                }
            }
        });

        img =(ImageButton)findViewById(R.id.imageButton);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent i = new Intent(MainActivity.this,MyService.class);
                    startService(i);
                    img.setImageResource(R.drawable.pause_new);




            }
        });

    }
}
