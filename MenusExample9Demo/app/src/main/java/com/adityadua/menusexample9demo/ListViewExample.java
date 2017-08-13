package com.adityadua.menusexample9demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by AdityaDua on 13/08/17.
 */

public class ListViewExample extends Activity {

    String colors[] = {
            "Red","Black","Blue","Yellow","Orange","Purple"
    };
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_example);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colors);
        lv = (ListView)findViewById(R.id.list2);
        lv.setAdapter(adapter);
    }
}
