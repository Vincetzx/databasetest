package com.example.god.databasetest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.UrlQuerySanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.DoubleBuffer;
import java.security.cert.CertificateNotYetValidException;

public class MainActivity extends AppCompatActivity {

    private Button mCreateButton;
    MyDatabaseHelper mDbHelper;
     private Button mAddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper=new MyDatabaseHelper(MainActivity.this,"BookStore.db",null,1);
        mCreateButton = (Button) findViewById(R.id.create_database);
        mAddButton= (Button) findViewById(R.id.add_data);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database=mDbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",454);
                values.put("price",16.96);
                database.insert("Book",null,values);
                values.clear();

            }
        });
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDbHelper.getWritableDatabase();
            }
        });
    }


}
