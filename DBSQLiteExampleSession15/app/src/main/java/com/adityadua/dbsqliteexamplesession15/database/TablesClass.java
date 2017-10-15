package com.adityadua.dbsqliteexamplesession15.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.adityadua.dbsqliteexamplesession15.utils.Constants;

/**
 * Created by AdityaDua on 02/09/17.
 */

public class TablesClass extends SQLiteOpenHelper {

    Context context;
    String cQuery= "Create table IF NOT EXISTS "+ Constants.TABLE_NAME +" ( "+
            Constants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            Constants.EMPLOYEE_NAME + " TEXT,"+
            Constants.MOBILE_NUMBER + " TEXT,"+
            Constants.SALARY+" INTEGER);";

    public TablesClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);
    }

}
