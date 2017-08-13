package com.adityadua.animacti7demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // https://github.com/android/platform_development/tree/master/samples/ApiDemos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ActivityDemo.class);
                i.putExtra("role","admin");
                startActivity(i);
            }
        });

        Button anim = (Button)findViewById(R.id.button2);
        anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(i);
            }
        });

    }
}
