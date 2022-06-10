package com.baewha.myeveryday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SecondActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    View gMap;
    MapFragment mapFrag;
    private Object MapFragment;

    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("병원 지도");


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng haspital1 = new LatLng(37.504565, 126.940919);
        MarkerOptions markerOpions1 = new MarkerOptions();
        markerOpions1.position(haspital1);
        markerOpions1.title("동작구 보건소");
        markerOpions1.snippet("보건소");

        LatLng haspital2 = new LatLng(37.496780, 126.952802);
        MarkerOptions markerOpions2 = new MarkerOptions();
        markerOpions2.position(haspital2);
        markerOpions2.title("에코이비인후과의원");
        markerOpions2.snippet("이비인후과");

        LatLng haspital3 = new LatLng(37.505361, 126.946511);
        MarkerOptions markerOpions3 = new MarkerOptions();
        markerOpions3.position(haspital3);
        markerOpions3.title("삼성드림내과의원");
        markerOpions3.snippet("내과");

        LatLng haspital4 = new LatLng(37.502535, 126.935829);
        MarkerOptions markerOpions4 = new MarkerOptions();
        markerOpions4.position(haspital4);
        markerOpions4.title("동작경희병원");
        markerOpions4.snippet("병원, 의원");

        mMap.addMarker(markerOpions1);
        mMap.addMarker(markerOpions2);
        mMap.addMarker(markerOpions3);
        mMap.addMarker(markerOpions4);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haspital1, 15));
    }
}
