package com.adityadua.googlemapsapidemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupMapIfNeeded();
    }

    private void setupMapIfNeeded() {
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions().position(new LatLng(28.4602767, 77.2854686)).title("My Home"));

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(28.4602767, 77.2854686));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

        googleMap.moveCamera(center);


        googleMap.getUiSettings();
        googleMap.setMyLocationEnabled(true);
        googleMap.animateCamera(zoom);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                double latitude = latLng.latitude;
                double longitude = latLng.longitude;

                Geocoder geocode;
                List<Address> addresses;
                geocode  = new Geocoder(MainActivity.this, Locale.getDefault());

                try{
                    addresses = geocode.getFromLocation(latitude,longitude,1);

                    String address = addresses.get(0).getAddressLine(0);
                    String city = addresses.get(0).getLocality();
                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName();

                    String finalAddress = "Address Of ::"+knownName+"\n "
                            +address+","+city+","+country+","+state+","+postalCode;

                    Toast.makeText(MainActivity.this, finalAddress, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
