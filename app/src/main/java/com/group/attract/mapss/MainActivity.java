package com.group.attract.mapss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    boolean mapReady = false;

    MarkerOptions one;
    MarkerOptions two;
    MarkerOptions three;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = new MarkerOptions()
                .position(new LatLng(47.4,-122.12))
        .title("one");
        two = new MarkerOptions()
                .position(new LatLng(7.4,-50.12))
                .title("two");
        three = new MarkerOptions()
                .position(new LatLng(27.4,-22.12))
                .title("three")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.googleg_disabled_color_18));
        Button btnHybrid = (Button) findViewById(R.id.city1);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady){

                    smth(new LatLng(47.62, -122.34));
                }
            }
        });

        Button btnSattelite = (Button) findViewById(R.id.city2);
        btnSattelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady){
                    smth(new LatLng(3, 4));
                }
            }
        });

        Button btnMap = (Button) findViewById(R.id.city3);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady){
                    smth(new LatLng(2, 1));
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapss);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        mapReady = true;
        map.addMarker(one);
        map.addMarker(two);
        map.addMarker(three);

    }

    public void smth(LatLng smth){
        CameraPosition cp = CameraPosition.builder()
                .target(smth)
                .zoom(14)
                .bearing(12)
                .tilt(45)
                .build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cp),2000,null);
    }
}
