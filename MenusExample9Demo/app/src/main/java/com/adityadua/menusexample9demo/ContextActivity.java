package com.adityadua.menusexample9demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 13/08/17.
 */

public class ContextActivity extends Activity{

    ListView lv;
    String contacts[]={"Aditya","Ajay","Sumit","Tarun","Rohit","Gaurav"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_layout);
        lv = (ListView)findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        lv.setAdapter(adapter);

        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose To Proceed");
        //menu.setHeaderIcon(R.drawable.example);

        menu.add("Call");
        menu.add("SMS");
        menu.add("Cancel");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle() == "Call"){
            Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
        }
        if(item.getTitle() == "SMS"){
            Toast.makeText(this, "SMS", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
