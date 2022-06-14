package com.baewha.myeveryday;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourActivity extends AppCompatActivity {
    myDBHelper myHelper;
    EditText ettitle, etcontent, ettitleresult, etcontentresult;
    Button btndelete, btnplus, btnback, btn;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
        setTitle("메모장");



        ettitle = (EditText) findViewById(R.id.etTitle);
        etcontent = (EditText) findViewById(R.id.etContent);
        etcontentresult = (EditText) findViewById(R.id.edtContentResult);
        ettitleresult = (EditText) findViewById(R.id.edtTitleResult);
        btndelete = (Button) findViewById(R.id.btnDelete);
        btnplus = (Button) findViewById(R.id.btnPlus);
        btn = (Button) findViewById(R.id.btn);
        btnback = (Button) findViewById(R.id.btnBack);

        myHelper = new myDBHelper(this);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                        + ettitle.getText().toString() +"',"
                        + etcontent.getText().toString() +");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strtitle = "제목" + "\r\n";
                String strcontent = "내용" + "\r\n";

                while (cursor.moveToNext()) {
                    strtitle += cursor.getString(0) + "\r\n";
                    strcontent += cursor.getString(1) + "\r\n";
                }

                ettitleresult.setText(strtitle);
                etcontentresult.setText(strcontent);

                cursor.close();
                sqlDB.close();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "groupDB", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL ( title CHAR(20) PRIMARY KEY, content CHAR(200));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }

    }

}
