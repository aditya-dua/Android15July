package com.adityadua.listviewsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String [] chaptersCovered={
            "Introduction to Android",
            "Android UI - I",
            "Android UI - II",
            "Android Advanced UI"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listview1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_list_item_1,
                chaptersCovered);
        list.setAdapter(adapter);
        // Similar to button you have a listener for item click....list view :
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)findViewById(R.id.textView2);
                tv.setText("Topic clicked is :"+chaptersCovered[position]);
                tv.setVisibility(TextView.VISIBLE);

                Toast.makeText(getApplicationContext(),"Topics clicked was:"+chaptersCovered[position],Toast.LENGTH_LONG).show();
            }
        });

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent ::
                Intent i = new Intent(MainActivity.this,NextActivity.class);

                startActivity(i);
            }
        });
    }
}
