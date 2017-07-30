package com.adityadua.session4demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // event Handling using : Interface OnClickListener

    Button logsBtn,toastBtn,sumBtn;
    EditText num1Edt,num2Edt;
    TextView restv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logsBtn = (Button) findViewById(R.id.logBtn);
        logsBtn.setOnClickListener(this);

        sumBtn = (Button) findViewById(R.id.addbtn);
        sumBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

      if(v.getId() == R.id.addbtn){
          Toast.makeText(getApplicationContext(),"Add Button Clicked",Toast.LENGTH_LONG).show();
      }else if(v.getId()==R.id.logBtn){
          Toast.makeText(getApplicationContext(),"Log Button Clicked",Toast.LENGTH_LONG).show();
      }


    }

}
