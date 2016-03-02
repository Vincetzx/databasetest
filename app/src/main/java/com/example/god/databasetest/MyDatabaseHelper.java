package com.example.god.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by god on 2016/3/2.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext=context;
    }

    public static final String CREATE_CATEGORY="create table Category("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";
    private Context mContext;
    public static final String CREATE_BOOK="create table Book("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text)";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext,"create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
