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
                    startActivity(i);
                }



            }
        });

    }
}
