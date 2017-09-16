package com.adityadua.intents7demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AdityaDua on 05/08/17.
 */

// Intents : are basically the message passing objects...
    // what type of message :
    // they can pass data about the activity & which activity is to be started

    // We can open a new Activity as well as pass some data which needs to be used.
    // Pass Data : using Bundles / putExtra


public class SecondActivity extends Activity {

    EditText userEdt,pwdEdt;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_xml);
        userEdt = (EditText)findViewById(R.id.editText);
        pwdEdt = (EditText)findViewById(R.id.editText2);

        login = (Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=userEdt.getText().toString();
                String pwd=pwdEdt.getText().toString();
                if(userName.equalsIgnoreCase("AcadGild") && pwd.equals("acadgild")){
                    Intent i = new Intent(SecondActivity.this,Third.class);
                    i.putExtra("userName",userName);
                    i.putExtra("age",23);
                    startActivity(i);
                }



            }
        });

    }
}
