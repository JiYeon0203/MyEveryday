package com.baewha.myeveryday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baewha.myeveryday.MainActivity;
import com.baewha.myeveryday.R;
import com.baewha.myeveryday.SingerAdapter;
import com.baewha.myeveryday.singeritem;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        setTitle("병원 리스트");

        ArrayList<singeritem> arrayList =new ArrayList<singeritem>();
        ListView listView =(ListView)findViewById(R.id.listView);
        SingerAdapter adapter = new SingerAdapter(this);

        adapter.addItem(new singeritem("동작구 보건소", "02-820-1423", "보건소"));
        adapter.addItem(new singeritem("에코이비인후과의원", "02-814-8899", "이비인후과"));
        adapter.addItem(new singeritem("삼성드림내과의원", "02-822-9658", "내과"));
        adapter.addItem(new singeritem("동작경희병원", "1670-8112", "병원, 의원"));
        adapter.addItem(new singeritem("이화사랑피부과의원", "02-824-7500", "피부과"));
        adapter.addItem(new singeritem("프라임의원", "02-826-2080", "피부과"));
        adapter.addItem(new singeritem("정동병원", "02-810-7900", "정형외과"));
        adapter.addItem(new singeritem("상도밝은안과의원", "02-812-2375", "안과"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-820-1423"));
                        startActivity(a);
                        break;
                    case 1:
                        Intent b = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-814-8899"));
                        startActivity(b);
                        break;
                    case 2:
                        Intent c = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-822-8899"));
                        startActivity(c);
                        break;
                    case 3:
                        Intent d = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1670-8112"));
                        startActivity(d);
                        break;
                    case 4:
                        Intent e = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-824-7500"));
                        startActivity(e);
                        break;
                    case 5:
                        Intent f = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-826-2080"));
                        startActivity(f);
                        break;
                    case 6:
                        Intent g = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-810-7900"));
                        startActivity(g);
                        break;
                    case 7:
                        Intent h = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-812-2375"));
                        startActivity(h);
                        break;

                    default:
                        Intent z = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:" + Uri.encode("119")));
                        startActivity(z);
                        break;
                }
            }
        });

    }
}
