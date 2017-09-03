package com.adityadua.dbsqliteexamplesession15.utils;

import android.content.Context;

import com.adityadua.dbsqliteexamplesession15.database.DBHelper;

/**
 * Created by AdityaDua on 02/09/17.
 */

public class CommonUtilties {

    public static DBHelper getDBObject(Context context){
        DBHelper dbHelper = DBHelper.getInstance(context);
        return dbHelper;
    }
}
