package com.baewha.myeveryday;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Song1 extends AppCompatActivity {

    ListView listViewMP3;
    Button btnPlay, btnStop;
    TextView tvMP3, tvTime;
    ProgressBar pbMP3;

    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song1);
        setTitle("노래");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MODE_PRIVATE);

        mp3List = new ArrayList<String>();

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        tvMP3 = (TextView) findViewById(R.id.tvMP3);
        tvTime = (TextView) findViewById(R.id.tvTime);
        pbMP3 = (ProgressBar) findViewById(R.id.pbMP3);


        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        for (File file : listFiles){
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 5);
            if (extName.equals((String) "mp3"))
                mp3List.add(fileName);
        }

        listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);
        listViewMP3.setItemChecked(0, true);

        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                selectedMP3 = mp3List.get(arg2);
            }
        });
        selectedMP3 = mp3List.get(0);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3);
                    mPlayer.prepare();
                    mPlayer.start();
                    btnPlay.setClickable(false);
                    btnStop.setClickable(true);
                    tvMP3.setText("실행중인 음악: " + selectedMP3);

                    new Thread(){
                        SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
                        public void run() {
                            if (mPlayer == null) return;
                            pbMP3.setMax(mPlayer.getDuration());
                            while(mPlayer.isPlaying()){
                                runOnUiThread(new Runnable(){
                                    public void run(){
                                        pbMP3.setProgress(mPlayer.getCurrentPosition());
                                        tvTime.setText("진행 시간 : " + timeFormat.format(mPlayer.getCurrentPosition()));
                                    }
                                });
                            }
                        }
                    }.start();
                }catch(IOException e){
                }
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true);
                btnStop.setClickable(false);
                tvMP3.setText("실행중인 음악: " + selectedMP3);

                pbMP3.setProgress(0);
                tvTime.setText("진행시간 : ");
            }
        });
        btnStop.setClickable(false);
    }

}
