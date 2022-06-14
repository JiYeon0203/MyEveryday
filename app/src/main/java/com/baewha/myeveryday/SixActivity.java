package com.baewha.myeveryday;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SixActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3, btn4, btn5;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six);
        setTitle("오늘 하루");

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SixActivity.this);
                dlg.setTitle("안좋아").setMessage("무슨 안좋은 일이라도 있었나봐요.\n" +
                        "blue 노래는 어떠세요?");
                dlg.setPositiveButton("들을래", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Song1.class);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("안들을래", null);
                dlg.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SixActivity.this);
                dlg.setTitle("그냥 그래").setMessage("좋지도 나쁘지도 않으신가봐요.\n" +
                        "purple 노래는 어떠세요?");
                dlg.setPositiveButton("들을래", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Song1.class);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("안들을래", null);
                dlg.show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SixActivity.this);
                dlg.setTitle("보통").setMessage("괜찮은거 같아 보이네요.\n" +
                        "yellow 노래는 어떠세요?");
                dlg.setPositiveButton("들을래", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Song1.class);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("안들을래", null);
                dlg.show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SixActivity.this);
                dlg.setTitle("나쁘지않아").setMessage("오늘 하루 잘 보냈나보네요.\n" +
                        "green 노래는 어떠세요?");
                dlg.setPositiveButton("들을래", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Song1.class);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("안들을래", null);
                dlg.show();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SixActivity.this);
                dlg.setTitle("좋아").setMessage("행복한 하루를 보냈나보네요.\n" +
                        "pink 노래는 어떠세요?");
                dlg.setPositiveButton("들을래", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Song1.class);
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("안들을래", null);
                dlg.show();
            }
        });




    }
}
