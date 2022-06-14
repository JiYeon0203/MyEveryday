package com.baewha.myeveryday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private TextView tv;
    private double storedValue;
    private char curOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        setTitle("계산기");


        tv = findViewById(R.id.tv);

    }

    public void onClick(View view) {
        String current = tv.getText().toString();

        switch (view.getId()) {
            case R.id.btn0:
                tv.setText(current + "0");
                break;
            case R.id.btn1:
                tv.setText(current + "1");
                break;
            case R.id.btn2:
                tv.setText(current + "2");
                break;
            case R.id.btn3:
                tv.setText(current + "3");
                break;
            case R.id.btn4:
                tv.setText(current + "4");
                break;
            case R.id.btn5:
                tv.setText(current + "5");
                break;
            case R.id.btn6:
                tv.setText(current + "6");
                break;
            case R.id.btn7:
                tv.setText(current + "7");
                break;
            case R.id.btn8:
                tv.setText(current + "8");
                break;
            case R.id.btn9:
                tv.setText(current + "9");
                break;

            case R.id.btn_plus:
                if (current.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '+';
                    tv.setText("");
                    break;
                }
            case R.id.btn_minus:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '-';
                    tv.setText("");
                    break;
                }
            case R.id.btn_multiply:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '*';
                    tv.setText("");
                    break;
                }
            case R.id.btn_divide:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '/';
                    tv.setText("");
                    break;
                }
            case R.id.btn_clear:
                tv.setText("");
                storedValue = 0;
                break;

            case R.id.btn_ok:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    double result = 0;
                    double thisValue = Double.parseDouble(tv.getText().toString());
                    switch (curOperator) {
                        case '+':
                            result = storedValue + thisValue;
                            break;
                        case '-':
                            result = storedValue - thisValue;
                            break;
                        case '*':
                            result = storedValue * thisValue;
                            break;
                        case '/':
                            result = storedValue / thisValue;
                            break;
                    }
                    tv.setText("" + result);
                    storedValue = 0;
                    break;
                }

            case R.id.btn_back:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


        }
    }
}

