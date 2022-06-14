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

        LatLng haspital5 = new LatLng(37.5049, 126.9507);
        MarkerOptions markerOpions5 = new MarkerOptions();
        markerOpions5.position(haspital5);
        markerOpions5.title("이화사랑피부과의원");
        markerOpions5.snippet("피부과");

        LatLng haspital6 = new LatLng(37.5042, 126.9384);
        MarkerOptions markerOpions6 = new MarkerOptions();
        markerOpions6.position(haspital6);
        markerOpions6.title("프라임의원");
        markerOpions6.snippet("피부과");

        LatLng haspital7 = new LatLng(37.5049, 126.9495);
        MarkerOptions markerOpions7 = new MarkerOptions();
        markerOpions7.position(haspital7);
        markerOpions7.title("정동병원");
        markerOpions7.snippet("정형외과");

        LatLng haspital8 = new LatLng(37.5009, 126.95);
        MarkerOptions markerOpions8 = new MarkerOptions();
        markerOpions8.position(haspital8);
        markerOpions8.title("상도밝은안과의원");
        markerOpions8.snippet("안과");

        LatLng haspital9 = new LatLng(37.4932, 126.9245);
        MarkerOptions markerOpions9 = new MarkerOptions();
        markerOpions9.position(haspital9);
        markerOpions9.title("서울특별시보라매병원");
        markerOpions9.snippet("종합병원");

        LatLng haspital10 = new LatLng(37.4995, 126.9293);
        MarkerOptions markerOpions10 = new MarkerOptions();
        markerOpions10.position(haspital10);
        markerOpions10.title("서울민플러스치과의원");
        markerOpions10.snippet("치과");

        LatLng haspital11 = new LatLng(37.4999, 126.9296);
        MarkerOptions markerOpions11 = new MarkerOptions();
        markerOpions11.position(haspital11);
        markerOpions11.title("삼성열린내과의원");
        markerOpions11.snippet("내과");


        mMap.addMarker(markerOpions1);
        mMap.addMarker(markerOpions2);
        mMap.addMarker(markerOpions3);
        mMap.addMarker(markerOpions4);
        mMap.addMarker(markerOpions5);
        mMap.addMarker(markerOpions6);
        mMap.addMarker(markerOpions7);
        mMap.addMarker(markerOpions8);
        mMap.addMarker(markerOpions9);
        mMap.addMarker(markerOpions10);
        mMap.addMarker(markerOpions11);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haspital1, 15));
    }
}
