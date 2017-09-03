package com.adityadua.dbsqliteexamplesession15;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.adityadua.dbsqliteexamplesession15.database.DBHelper;
import com.adityadua.dbsqliteexamplesession15.model.Employee;
import com.adityadua.dbsqliteexamplesession15.utils.CommonUtilties;
import com.adityadua.dbsqliteexamplesession15.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String [] employee_name={
            "Ram","Mohan","Shyam","Rohit","Neeraj","Rishi"
    };
    String [] employee_number={
            "1234567890","2345678901","3456789012",
            "4567890123","5678901234","6789012345"
    };
    String [] employee_salary={
            "12300","23400","31145","40056","56700","60708"
    };
    ListView list;
    List<Employee> dataList;
    DBHelper dbHelper;
    ArrayAdapter<String> myAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = CommonUtilties.getDBObject(this);
        list = (ListView)findViewById(R.id.list);

        int count = dbHelper.getFullContent(Constants.TABLE_NAME,null);
        Toast.makeText(this, "Count of total rows ::"+count, Toast.LENGTH_SHORT).show();
        if(count == 0){
            insertEmployee();
            //Toast.makeText(this, "Values Inserted!", Toast.LENGTH_SHORT).show();
        }

        // selecting all the rows

        dataList = dbHelper.getAllEmployees();
        List<String> employeeStringList =  new ArrayList<>();

        Log.i("data List::","Size IS ::"+dataList.size());

        for(int i=0;i<dataList.size();i++){
            employeeStringList.add(dataList.get(i).toString());
        }
        Log.i("employeeStringList","Size IS ::"+employeeStringList.size());

       // myAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,employeeStringList);


        myAdaptor = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.listText,employeeStringList);
        myAdaptor.notifyDataSetChanged();
        list.setAdapter(myAdaptor);
        list.setOnItemClickListener(this);

    }

    private void insertEmployee(){

        for(int i =0 ;i<employee_name.length;i++){

            ContentValues cv = new ContentValues();
            cv.put(Constants.EMPLOYEE_NAME,employee_name[i]);
            cv.put(Constants.MOBILE_NUMBER,employee_number[i]);
            cv.put(Constants.SALARY,employee_salary[i]);

            dbHelper.insertContentValues(Constants.TABLE_NAME,cv);
            //Toast.makeText(this, "Insert called ::"+i, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this,EmployeeDetails.class);
        i.putExtra(Constants.EMPLOYEE_NAME,employee_name[position]);
        i.putExtra(Constants.MOBILE_NUMBER,employee_number[position]);

        startActivityForResult(i,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
