package com.adityadua.menusexample9demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Whenever you creating a runtime view...
    //Like here in menu's we are creating a
    // view for menu's
    // fragments
    // view in Java
    // Atciivty is corrosponding to 1 UI file


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b= (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this,ListViewExample.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Item's Id is :"+item.getItemId(), Toast.LENGTH_SHORT).show();
        if(item.getItemId() == R.id.save){
            Toast.makeText(this, "Data Saved Successfuly", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.settings){
            startActivity(new Intent(this,SecondActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
