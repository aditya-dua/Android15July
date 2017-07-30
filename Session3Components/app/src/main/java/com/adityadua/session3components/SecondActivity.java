package com.adityadua.session3components;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 22/07/17.
 */

public class SecondActivity extends Activity implements View.OnClickListener{

    Button toast,gender,games;
    EditText edt;
    RadioButton rbmale,rbfemale;
    CheckBox cricket,football;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface_event);

        if(savedInstanceState != null){
            // you will set the values to previous
            String score=savedInstanceState.getString("HighScore");
        }
        edt = (EditText)findViewById(R.id.editText);

        rbfemale = (RadioButton)findViewById(R.id.radioButton2);
        rbmale=(RadioButton)findViewById(R.id.radioButton);
        gender =(Button)findViewById(R.id.button3);
        gender.setOnClickListener(this);

        toast = (Button) findViewById(R.id.login);
        toast.setOnClickListener(this);

        cricket=(CheckBox)findViewById(R.id.checkBox);
        football = (CheckBox)findViewById(R.id.checkBox2);
        games = (Button)findViewById(R.id.button4);
        games.setOnClickListener(this);
    }
    /**
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.interface_event);

        edt = (EditText)findViewById(R.id.editText);
        toast = (Button) findViewById(R.id.login);

        toast.setOnClickListener(this);


    }*/

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.login){
            String msg="Toast IS ::"+edt.getText().toString();
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            toast.setBackground(R.mipmap.ic_launcher);

        }
        else if(v.getId()==R.id.button3){
            if(rbmale.isChecked()){
                Toast.makeText(getApplicationContext(),"Gender : Male",Toast.LENGTH_LONG).show();
            }else if(rbfemale.isChecked()){
                Toast.makeText(getApplicationContext(),"Gender : Female",Toast.LENGTH_LONG).show();
            }
        }
        else if(v.getId()==R.id.button4){
            if(cricket.isChecked() && football.isChecked()){
                Toast.makeText(getApplicationContext(),"Games I like are : Cricket & Football",Toast.LENGTH_LONG).show();
            }else if(cricket.isChecked()){
                Toast.makeText(getApplicationContext(),"Game I like : Cricket",Toast.LENGTH_LONG).show();
            }else if(football.isChecked()){
                Toast.makeText(getApplicationContext(),"Game I like : FootBall",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("Highscore","500");

    }
}
