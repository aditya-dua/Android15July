package com.adityadua.session3components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button loginBtn,resetBtn;
    EditText userNameEdt,pwdEdt;
    TextView statusTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Type casting from XML to Java
        userNameEdt = (EditText)findViewById(R.id.usernameedt);
        pwdEdt = (EditText) findViewById(R.id.passwordedt);
        statusTV = (TextView) findViewById(R.id.login_status);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        // Event Handler :: onClick:
        // 3 ways to set OnClickListener.....Anonymous Inner Class Dec
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = userNameEdt.getText().toString();
                String password = pwdEdt.getText().toString();
                statusTV.setVisibility(TextView.VISIBLE);
                if(userName.equalsIgnoreCase("aditya") && password.equals("aditya")){
                    statusTV.setText("Login Success!\nUser : Aditya");
                    Toast.makeText(getApplicationContext(),"Login Success for "+userName,Toast.LENGTH_LONG).show();
                }else{
                    statusTV.setText("Incorrect Username/password");
                }

            }
        });



    }
    //Other way to set the OnCLick by creating a method which uses
    // View as parameter.

   /* public void resetText(View v){
        userNameEdt.setText("");
        pwdEdt.setText("");
        statusTV.setVisibility(TextView.INVISIBLE);
    }*/

    @Override
    public void onClick(View v) {

    }
}
