package com.adityadua.dbsqliteexamplesession15.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.Toast;

import com.adityadua.dbsqliteexamplesession15.model.Employee;
import com.adityadua.dbsqliteexamplesession15.utils.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AdityaDua on 02/09/17.
 */

public class DBHelper {

    /* dont create the object of this class directly instead have a class
which will call the getInstance method of this class **/

    private SQLiteDatabase db;
    private final Context context;
    private final TablesClass dbHelperSQLiteOpenHelper;
    public static DBHelper db_helper = null;

    public static DBHelper getInstance(Context c){
        try{
            if(db_helper == null){
                db_helper = new DBHelper(c);
                db_helper.open(); //=> open the db over here
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  db_helper;
    }

    public DBHelper(Context c) {
        context = c;
        dbHelperSQLiteOpenHelper = new TablesClass(context, Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }

    public void close(){
        if(db.isOpen()){
            db.close();
        }
    }

    public void open() throws SQLiteException {
        try{
            db= dbHelperSQLiteOpenHelper.getWritableDatabase();
        }catch (Exception e){
            db= dbHelperSQLiteOpenHelper.getReadableDatabase();
            e.printStackTrace();

        }
    }

    public long insertContentValues(String tableName, ContentValues content){
        long id =0;
        try{
            db.beginTransaction();
            id = db.insert(tableName,null,content);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

        return id;
    }
    // ContentValues
    // cursors

    public int getFullContent(String tabName,String where){

        int count = 0;
        Cursor cursor = db.query(false,tabName,null,where,null,null,null,null,null);

        try{
            if(cursor !=null){
                cursor.moveToFirst();
                count = cursor.getCount();
                Toast.makeText(context, "Count from method Full is::"+cursor.getCount(), Toast.LENGTH_SHORT).show();
                cursor.close();
            }
        }finally {
            cursor.close();
        }
        return  count;
    }

    public void deleteRecords(String tableName,String whereClause,String [] wehreArgs){
        try{
            db.beginTransaction();
            db.delete(tableName,whereClause,wehreArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }


    public int updateRecord(String tableName,ContentValues values,String whereClause,String [] whereArgs){
        int a = 0;
        try{
            db.beginTransaction();
            a = db.update(tableName,values,whereClause,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
        return  a;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new LinkedList<>();
        String query = "select * from "+Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        Employee emp = null;

        Log.i("cursor:getAllEmployees","Count is ::"+cursor.getCount());
        if(cursor.moveToFirst()){
            do{
                emp = new Employee();
                emp.setEmployeeID(cursor.getInt(0));
                emp.setEmployeeName(cursor.getString(1));
                emp.setMobileNumber(cursor.getString(2));
                emp.setSalary(cursor.getInt(3));

                employees.add(emp);

            }while(cursor.moveToNext());
        }
        Log.i("cursor:getAllEmployees","Employee ISS"+employees.size());

        return employees;
    }

}
