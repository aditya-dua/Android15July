package com.adityadua.listviewsexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by AdityaDua on 23/07/17.
 */

public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row);

        Button nextPage=(Button) findViewById(R.id.button2);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent
                        (Intent.ACTION_DIAL, Uri.parse("tel:12345"));
                startActivity(dial);
            }
        });

        Button openWP=(Button)findViewById(R.id.button3);
        openWP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webPage=new Intent
                        (Intent.ACTION_VIEW,Uri.parse("http://www.acadgild.com"));
                startActivity(webPage);
            }
        });
    }
}
