package com.baewha.myeveryday;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FiveActivity extends AppCompatActivity {
    Switch sw1, sw2, sw3, sw4;
    LinearLayout ll1, ll2, ll3, ll4;
    RadioButton rb1, rb2;
    RadioGroup rg;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16;
    Button btn, btn_back;

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        super.onCreateOptionsMenu(menu2);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu2, menu2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.item2:
                Intent intent = new Intent(getApplicationContext(), SixActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five);
        setTitle("하루 목표");



        sw1 = findViewById(R.id.Sw1);
        sw2 = findViewById(R.id.Sw2);
        sw3 = findViewById(R.id.Sw3);
        sw4 = findViewById(R.id.Sw4);
        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        ll4 = findViewById(R.id.ll4);
        rg = findViewById(R.id.rg);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        btn = findViewById(R.id.btn);
        btn_back = findViewById(R.id.btn_back);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        cb6 = findViewById(R.id.cb6);
        cb7 = findViewById(R.id.cb7);
        cb8 = findViewById(R.id.cb8);
        cb9 = findViewById(R.id.cb9);
        cb10 = findViewById(R.id.cb10);
        cb11 = findViewById(R.id.cb11);
        cb12 = findViewById(R.id.cb12);
        cb13 = findViewById(R.id.cb13);
        cb14 = findViewById(R.id.cb14);
        cb15 = findViewById(R.id.cb15);
        cb16 = findViewById(R.id.cb16);

        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw1.isChecked() == true) {
                    ll1.setVisibility(View.VISIBLE);
                }
                else{
                    ll1.setVisibility(View.INVISIBLE);
                    ll1.setVisibility(View.GONE);
                }
            }
        });

        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw2.isChecked() == true) {
                    ll2.setVisibility(View.VISIBLE);
                }
                else{
                    ll2.setVisibility(View.INVISIBLE);
                    ll2.setVisibility(View.GONE);
                }
            }
        });

        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw3.isChecked() == true) {
                    ll3.setVisibility(View.VISIBLE);
                }
                else{
                    ll3.setVisibility(View.INVISIBLE);
                    ll3.setVisibility(View.GONE);
                }
            }
        });

        sw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw4.isChecked() == true) {
                    ll4.setVisibility(View.VISIBLE);
                }
                else{
                    ll4.setVisibility(View.INVISIBLE);
                    ll4.setVisibility(View.GONE);
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rb1.isChecked() && cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()
                        && cb5.isChecked() && cb6.isChecked() && cb7.isChecked() && cb8.isChecked()
                        && cb9.isChecked() && cb10.isChecked() && cb11.isChecked() && cb12.isChecked()
                        && cb13.isChecked() && cb14.isChecked() && cb15.isChecked() && cb16.isChecked()) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(FiveActivity.this);
                    dlg.setTitle("목표달성!").setMessage("축하합니다. 오늘 하루 잘보내셨네요!");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }
                else {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(FiveActivity.this);
                    dlg.setTitle("목표 체크").setMessage("앗 체크 덜 된게 있는 것 같아요. 확인해보세요!");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }

                if(rb2.isChecked()){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(FiveActivity.this);
                    dlg.setTitle("목표 체크").setMessage("아쉽네요. 그래도 내일은 잘 해보죠!");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                }

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
