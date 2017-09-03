package com.adityadua.dbsqliteexamplesession15;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adityadua.dbsqliteexamplesession15.database.DBHelper;
import com.adityadua.dbsqliteexamplesession15.utils.CommonUtilties;
import com.adityadua.dbsqliteexamplesession15.utils.Constants;

/**
 * Created by AdityaDua on 03/09/17.
 */

public class EmployeeDetails extends AppCompatActivity implements View.OnClickListener{

    EditText nameEdt,numberEdt;
    TextView nametv,numbertv;
    Button del,update;
    String empName,empNumber;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        nameEdt = (EditText)findViewById(R.id.nameEdt);
        numberEdt = (EditText)findViewById(R.id.numberEdt);

        nametv = (TextView)findViewById(R.id.employeeName);
        numbertv = (TextView)findViewById(R.id.employeeNumber);

        Intent i = getIntent();
        empName = i.getStringExtra(Constants.EMPLOYEE_NAME);
        empNumber = i.getStringExtra(Constants.MOBILE_NUMBER);

        nametv.setText(empName);
        numbertv.setText(empNumber);

        dbHelper = CommonUtilties.getDBObject(this);

        del = (Button)findViewById(R.id.delete);
        update = (Button)findViewById(R.id.Update);
        del.setOnClickListener(this);
        update.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.delete){
            dbHelper.deleteRecords(Constants.TABLE_NAME,Constants.EMPLOYEE_NAME+" = '"+empName+"'",null);
            Log.i("Delete","Deleted");
            finish();
        }else if(v.getId()==R.id.Update){
            ContentValues cv = new ContentValues();
            cv.put(Constants.EMPLOYEE_NAME,nameEdt.getText().toString());
            cv.put(Constants.MOBILE_NUMBER,numberEdt.getText().toString());

            dbHelper.updateRecord(Constants.TABLE_NAME,cv,Constants.EMPLOYEE_NAME+" =?",new String[] {empName});
            finish();
        }
    }
}
